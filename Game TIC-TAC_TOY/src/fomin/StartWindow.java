package fomin;

import com.sun.org.apache.bcel.internal.generic.FADD;
import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindow extends JFrame implements ActionListener {
    static final String[] NAMES_OF_LEVELS = {"EASY", "MEDIUM", "HARD", "NIGHTMARE"};
    static final int WIDTH = 1000;
    static final int HEIGHT = 1000;
    private JPanel radioButtonsPanel = new JPanel(new FlowLayout());
    private JPanel[] menuRowPanel = new JPanel[6];
    private JPanel menuPanel = new JPanel(new GridLayout(6, 1));
    static JButton startButton = new JButton("START");
    static ButtonGroup buttonGroup = new ButtonGroup();
    static JRadioButton[] levelRadioButton = new JRadioButton[4];
    static JLabel sizeLabel = new JLabel("Select the size of the game map:");
    static JLabel numberOfSymbolsToWinLabel = new JLabel("Choose the number of symbols to win:");
    static JLabel greaterLabel = new JLabel("<html><p align='center'>Welcome to the game TIC-TAC-toe!<br> Select the necessary parameters to start the game and click 'start'" +
            "<br>Number of symbols for win should to be greater than 2 and less or equal than size of the map.<br>Size of the map should be greater than 2 and less than 24</p></html>");
    static JLabel levelLabel = new JLabel("Select the difficulty level:");
    static JTextField sizeTF = new JTextField(2);
    static JTextField numberOfSymbolsToWinTF = new JTextField(2);
    Font textMenuFont = new Font("SANS_SERIF", Font.BOLD, 35);
    Font textGreaterFont = new Font("SANS_SERIF", Font.BOLD, 30);
    Font textButton = new Font("SANS_SERIF", Font.BOLD, 100);

    StartWindow() {
        super();
        setTitle("Tic-tic-toe by Dmitriy Fomin");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        initializationElements();
        setVisible(true);
    }

    protected void initializationElements() {
        greaterLabel.setFont(textGreaterFont);
        sizeLabel.setFont(textMenuFont);
        sizeTF.setFont(textMenuFont);
        numberOfSymbolsToWinLabel.setFont(textMenuFont);
        numberOfSymbolsToWinTF.setFont(textMenuFont);
        levelLabel.setFont(textMenuFont);
        startButton.setFont(textButton);
        for (int i = 0; i < menuRowPanel.length; i++) {
            menuRowPanel[i] = new JPanel();
        }
        menuRowPanel[0].add(sizeLabel);
        menuRowPanel[1].add(sizeTF);
        menuRowPanel[2].add(numberOfSymbolsToWinLabel);
        menuRowPanel[3].add(numberOfSymbolsToWinTF);
        menuRowPanel[4].add(levelLabel);
        for (int i = 1; i <= levelRadioButton.length; i++) {
            levelRadioButton[i - 1] = new JRadioButton(NAMES_OF_LEVELS[i - 1]);
            levelRadioButton[i - 1].setFont(textMenuFont);
            buttonGroup.add(levelRadioButton[i - 1]);
            radioButtonsPanel.add(levelRadioButton[i - 1]);
        }
        levelRadioButton[2].setSelected(true);
        menuRowPanel[5].add(radioButtonsPanel);
        for (int i = 0; i < menuRowPanel.length; i++) {
            menuPanel.add(menuRowPanel[i]);
        }
        add(greaterLabel, BorderLayout.NORTH);
        add(menuPanel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
        startButton.addActionListener(this);
        sizeTF.setText(null);
        numberOfSymbolsToWinTF.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isSetValidValue()) {
            Main.newStartParametersGame();
        }
    }

    private static boolean isSetValidValue() {
        int size = 0;
        int numberOfSymbols = 0;
        sizeTF.setBackground(Color.WHITE);
        numberOfSymbolsToWinTF.setBackground(Color.WHITE);
        if (sizeTF.getText().equals("") || numberOfSymbolsToWinTF.equals("")) {
            JOptionPane.showMessageDialog(null, "ERROR\nYou should enter size of the map and number of symbols for win");
            if (sizeTF.getText().equals("")) sizeTF.setBackground(Color.RED);
            if (numberOfSymbolsToWinTF.getText().equals("")) numberOfSymbolsToWinTF.setBackground(Color.RED);
            return false;
        }
        try {
            size = Integer.parseInt(sizeTF.getText());
        } catch (Exception e) {
            e.printStackTrace();
            sizeTF.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, "ERROR\nYou should enter only integer numbers.\nYour entered size is not Integer value!\nTry again, please.");
            sizeTF.setText(null);
            return false;
        }
        try {
            numberOfSymbols = Integer.parseInt(numberOfSymbolsToWinTF.getText());
        } catch (Exception e) {
            e.printStackTrace();
            numberOfSymbolsToWinTF.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, "ERROR\nYou should enter only integer numbers.\nYour entered number of symbols is not Integer value!\nTry again, please.");
            numberOfSymbolsToWinTF.setText(null);
            return false;
        }
        if (!(size > 2 && size <= 23)) {
            sizeTF.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, "ERROR\nSize of the map should be greater than 2 and less than 24");
            sizeTF.setText(null);
            return false;
        }
        if (!(numberOfSymbols > 2 && numberOfSymbols <= size)) {
            numberOfSymbolsToWinTF.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, "ERROR\nNumber of symbols for win should to be greater than 2 and less or equal than size of the map");
            numberOfSymbolsToWinTF.setText(null);
            return false;
        }
        GameWindow.sizeOfMap = size;
        InterGame.pointsToWin = numberOfSymbols;
        for (int i = 0; i < levelRadioButton.length; i++) {
            if (levelRadioButton[i].isSelected()) {
                InterGame.levelAI = i;
            }
        }
        return true;
    }
}
