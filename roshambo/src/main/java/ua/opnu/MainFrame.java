package ua.opnu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame implements ActionListener {

    public MainFrame(String title) throws HeadlessException {
        super(title);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

        JButton rockButton = new JButton("Камінь");
        rockButton.addActionListener(this);
        rockButton.setActionCommand("rock");
        JButton paperButton = new JButton("Папір");
        paperButton.addActionListener(this);
        paperButton.setActionCommand("paper");
        JButton scissorsButton = new JButton("Ножиці");
        scissorsButton.addActionListener(this);
        scissorsButton.setActionCommand("scissors");

        this.add(rockButton);
        this.add(paperButton);
        this.add(scissorsButton);

        this.pack();
        this.setVisible(true);
    }

    private GameShape generateShape() {

        int random = new Random().nextInt(3);

        if (random == 0) {
            return new Rock();
        } else if (random == 1) {
            return new Paper();
        } else {
            return new Scissors();
        }
    }

    private int checkWinner(GameShape player, GameShape computer) {
        // Check for a tie
        if ((player instanceof Rock && computer instanceof Rock) ||
                (player instanceof Paper && computer instanceof Paper) ||
                (player instanceof Scissors && computer instanceof Scissors)) {
            return 0; // It's a tie
        }

        // Check for player winning conditions
        if ((player instanceof Rock && computer instanceof Scissors) ||
                (player instanceof Scissors && computer instanceof Paper) ||
                (player instanceof Paper && computer instanceof Rock)) {
            return 1; // Player wins
        }

        // If it's not a tie and the player didn't win, the computer must have won
        return -1; // Computer wins
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Generate the computer's move
        GameShape computerShape = generateShape();

        GameShape playerShape = null; // Initialize the player's shape
        // Determine which button the player clicked
        switch (e.getActionCommand()) {
            case "rock":
                playerShape = new Rock();
                break;
            case "paper":
                playerShape = new Paper();
                break;
            case "scissors":
                playerShape = new Scissors();
                break;
        }

        // Визначити результат гри
        int gameResult = checkWinner(playerShape, computerShape);

        // Сформувати повідомлення
        String message = "Player shape: " + playerShape + ". Computer shape: " + computerShape + ". ";
        switch (gameResult) {
            case -1:
                message += "Computer has won!";
                break;
            case 0:
                message += "It's a tie!";
                break;
            case 1:
                message += "Player has won!";
        }

        // Вивести діалогове вікно з повідомленням
        JOptionPane.showMessageDialog(null, message);
    }
}
