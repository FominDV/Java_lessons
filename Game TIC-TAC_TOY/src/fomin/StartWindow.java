package fomin;

import com.sun.org.apache.bcel.internal.generic.FADD;

import javax.swing.*;
import java.awt.*;

public class StartWindow extends JFrame {
    static final int WIDTH = 1000;
    static final int HEIGHT = 1000;
    static JPanel menuPanel = new JPanel(new GridLayout(4, 1));
    static JLabel sizeLabel = new JLabel("Select the size of the game map:");
    static JLabel numberOfSymbolsToWinLabel = new JLabel("Choose the number of symbols to win:");
    static JLabel greaterLabel = new JLabel("<html><p align='center'>Welcome to the game TIC-TAC-toe!<br> Select the necessary parameters to start the game and click 'start'" +
            "<br>Number of symbols for win should to be greater than 2 and less or equal than size of the map.</p></html>");
    static JLabel levelLabel = new JLabel("Select the difficulty level:");
    static JButton startButton = new JButton("START");
    static JRadioButton[] levelRadioButton = new JRadioButton[3];
    static ButtonGroup buttonGroup = new ButtonGroup();
    Font textMenuFont = new Font("SANS_SERIF", Font.BOLD, 60);
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
        menuPanel.setFont(textMenuFont);
        startButton.setFont(textButton);
        add(greaterLabel, BorderLayout.NORTH);
        add(menuPanel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
    }
}
