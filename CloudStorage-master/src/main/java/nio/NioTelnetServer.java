package nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class NioTelnetServer {
    private final ByteBuffer buffer = ByteBuffer.allocate(512);

    //commands
    private static final String HELP = "--help";
    private static final String LS = "ls";
    private static final String EXIT = "exit";
    private static final String TOUCH = "touch";
    private static final String MKDIR = "mkdir";
    private static final String CD = "cd";
    private static final String RM = "rm";
    private static final String COPY = "copy";
    private static final String CAT = "cat";

    //Description of commands
    private static final String LS_COMMAND = String.format("\t%s          view all files from current directory", LS);
    private static final String MKDIR_COMMAND = String.format("\t%s       create directory 'mkdir dir_name'", MKDIR);
    private static final String TOUCH_COMMAND = String.format("\t%s       create file 'touch file_name'", TOUCH);
    private static final String CD_COMMAND = String.format("\t%s       move to path 'cd path'", CD);
    private static final String COPY_COMMAND = String.format("\t%s        copy file 'copy src dst'", COPY);
    private static final String RM_COMMAND = String.format("\t%s          remove file or directory 'rm data_name'", RM);
    private static final String CAT_COMMAND = String.format("\t%s         view entity of file 'cat file_name'", CAT);

    private static final Path ROOT_DIRECTORY = Paths.get("server");
    private String currentDirectory;

    public NioTelnetServer() throws IOException {
        currentDirectory = ROOT_DIRECTORY.toString();
        ServerSocketChannel server = ServerSocketChannel.open(); // открыли
        server.bind(new InetSocketAddress(1234));
        server.configureBlocking(false); // ВАЖНО
        Selector selector = Selector.open();
        server.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("Server started");
        while (server.isOpen()) {
            selector.select();
            var selectionKeys = selector.selectedKeys();
            var iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                var key = iterator.next();
                if (key.isAcceptable()) {
                    handleAccept(key, selector);
                } else if (key.isReadable()) {
                    handleRead(key, selector);
                }
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            new NioTelnetServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleRead(SelectionKey key, Selector selector) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        int readBytes = channel.read(buffer);
        if (readBytes < 0) {
            channel.close();
            return;
        } else if (readBytes == 0) {
            return;
        }

        buffer.flip();
        StringBuilder sb = new StringBuilder();
        while (buffer.hasRemaining()) {
            sb.append((char) buffer.get());
        }
        buffer.clear();

        // TODO: 05.03.2021
        // touch (имя файла) - создание файла
        // mkdir (имя директории) - создание директории
        // cd (path) - перемещение по дереву папок
        // rm (имя файла или папки) - удаление объекта
        // copy (src, target) - копирование файла
        // cat (имя файла) - вывод в консоль содержимого

        if (key.isValid()) {
            String command = sb.toString()
                    .replaceAll("[\n\r]", "");
            String[] commandParts = command.split(" ");
            switch (commandParts[0]) {
                case HELP:
                    if (commandParts.length != 1) {
                        sendErrorMessage(key);
                        return;
                    }
                    help(key);
                    break;
                case LS:
                    if (commandParts.length != 1) {
                        sendErrorMessage(key);
                        return;
                    }
                    sendMessage(getFilesList(), key);
                    break;
                case EXIT:
                    if (commandParts.length != 1) {
                        sendErrorMessage(key);
                        return;
                    }
                    System.out.println("Client logged out. IP: " + channel.getRemoteAddress());
                    channel.close();
                    return;
                case TOUCH:
                    if (commandParts.length != 2) {
                        sendErrorMessage(key);
                        return;
                    }
                    create(commandParts[1], key, FileType.FILE);
                    break;
                case MKDIR:
                    if (commandParts.length != 2) {
                        sendErrorMessage(key);
                        return;
                    }
                    create(commandParts[1], key, FileType.DIRECTORY);
                    break;
                case CD:
                    if (commandParts.length != 2) {
                        sendErrorMessage(key);
                        return;
                    }
                    cd(commandParts[1], key);
                    break;
                case COPY:
                    if (commandParts.length != 3) {
                        sendErrorMessage(key);
                        return;
                    }
                    copy(commandParts[1], commandParts[2], key);
                    break;
                case RM:
                    if (commandParts.length != 2) {
                        sendErrorMessage(key);
                        return;
                    }
                    rm(commandParts[1], key);
                    break;
                case CAT:
                    if (commandParts.length != 2) {
                        sendErrorMessage(key);
                        return;
                    }
                    cat(commandParts[1], key);
                    break;
                default:
                    sendErrorMessage(key);
            }
        }
        sendName(channel);
    }

    private void cat(String source, SelectionKey key) throws IOException {
        Path path = getNormalizePath(source);
        if (!Files.isRegularFile(path)) {
            sendMessage("file not found", key);
            return;
        }
        for (String line : Files.readAllLines(path)) {
            sendMessage(line, key);
        }
    }

    private void rm(String source, SelectionKey key) throws IOException {
        Path path = getNormalizePath(source);
        if (!Files.exists(path)) {
            sendMessage("source was not found", key);
            return;
        }
        if (Files.isDirectory(path)) {
            deleteDirectory(path);
        } else {
            Files.delete(path);
        }
        sendMessage("removing is successful", key);
    }

    private void deleteDirectory(Path path) throws IOException {
        Files.walkFileTree(path, new SimpleFileVisitor<>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private void copy(String source, String destination, SelectionKey key) throws IOException {
        Path sourcePath = getNormalizePath(source);
        Path destinationPath = getNormalizePath(destination);
        try {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (FileNotFoundException e) {
            sendMessage("source file is not exist", key);
        } catch (NoSuchFileException e) {
            sendMessage("file was not found", key);
        } catch (IOException e) {
            throw e;
        }
        sendMessage("copying is successful", key);
    }

    //Move to directory by path
    private void cd(String pathString, SelectionKey key) throws IOException {
        Path path = getNormalizePath(pathString);
        if (Files.isDirectory(path)) {
            currentDirectory = path.toString();
        } else {
            sendErrorMessage(key);
        }
    }

    private void create(String name, SelectionKey key, FileType fileType) throws IOException {
        Path newFile = Paths.get(currentDirectory, name);
        if (Files.exists(newFile)) {
            sendMessage("Already exist", key);

        } else {
            if (fileType == FileType.FILE) {
                Files.createFile(newFile);
            } else {
                Files.createDirectory(newFile);
            }
            sendMessage(name + " was created", key);
        }
    }

    private void sendName(SocketChannel channel) throws IOException {
        channel.write(
                ByteBuffer.wrap(String.format("%s>: ", currentDirectory)
                        .getBytes(StandardCharsets.UTF_8)
                )
        );
    }

    private String getFilesList() {
        return String.join("\t", new File(currentDirectory).list());
    }

    private void sendMessage(String message, SelectionKey key) throws IOException {
        message += "\n\r";
            if (key.isValid() && key.channel() instanceof SocketChannel) {
                ((SocketChannel) key.channel())
                        .write(ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8)));
            }
    }

    private void handleAccept(SelectionKey key, Selector selector) throws IOException {
        SocketChannel channel = ((ServerSocketChannel) key.channel()).accept();
        channel.configureBlocking(false);
        System.out.println("Client accepted. IP: " + channel.getRemoteAddress());
        channel.register(selector, SelectionKey.OP_READ, "some attach");
        channel.write(ByteBuffer.wrap("Hello user!\n\r".getBytes(StandardCharsets.UTF_8)));
        channel.write(ByteBuffer.wrap("Enter --help for support info\n\r".getBytes(StandardCharsets.UTF_8)));
        sendName(channel);
    }

    private void help(SelectionKey key) throws IOException {
        sendMessage(LS_COMMAND, key);
        sendMessage(MKDIR_COMMAND, key);
        sendMessage(TOUCH_COMMAND, key);
        sendMessage(CD_COMMAND, key);
        sendMessage(COPY_COMMAND, key);
        sendMessage(RM_COMMAND, key);
        sendMessage(CAT_COMMAND, key);
    }

    private enum FileType {
        FILE, DIRECTORY
    }

    private void sendErrorMessage(SelectionKey key) throws IOException {
        sendMessage("unknown command", key);
    }

    //User can insert absolute or relative path
    private Path getNormalizePath(String source) {
        Path path = Paths.get(source);
        if (!path.startsWith(ROOT_DIRECTORY)) {
            path = Paths.get(currentDirectory).resolve(path).normalize();
        }
        if (!path.startsWith(ROOT_DIRECTORY)) {
            return Paths.get(",");
        }
        return path;
    }
}
