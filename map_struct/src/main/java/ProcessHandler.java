public class ProcessHandler {

    public static void main(String[] args) {
        Entity entity = new Entity("Gosha", new EntityCat("Tom",7));
        DTO dto = UserMapper.userMapper.entityToDto(entity);
        System.out.println(dto);
    }
}
