package fomin;

import com.sun.org.apache.bcel.internal.generic.FADD;
import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.*;

public class StartWindow extends JFrame {
    static final String[] NAMES_OF_LEVELS={"EASY","MEDIUM","HARD","NIGHTMARE"};
    static final int WIDTH = 1000;
    static final int HEIGHT = 1000;
    static JPanel[] menuRowPanel = new JPanel[6];
    static JPanel radioButtonsPanel = new JPanel(new FlowLayout());
    static JPanel menuPanel = new JPanel(new GridLayout(6, 1));
    static JLabel sizeLabel = new JLabel("Select the size of the game map:");
    static JLabel numberOfSymbolsToWinLabel = new JLabel("Choose the number of symbols to win:");
    static JLabel greaterLabel = new JLabel("<html><p align='center'>Welcome to the game TIC-TAC-toe!<br> Select the necessary parameters to start the game and click 'start'" +
            "<br>Number of symbols for win should to be greater than 2 and less or equal than size of the map.</p></html>");
    static JLabel levelLabel = new JLabel("Select the difficulty level:");
    static JButton startButton = new JButton("START");
    static JRadioButton[] levelRadioButton = new JRadioButton[4];
    static ButtonGroup buttonGroup = new ButtonGroup();
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
            levelRadioButton[i - 1] = new JRadioButton(NAMES_OF_LEVELS[i-1]);
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
    }
}
