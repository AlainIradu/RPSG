import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
 
public class RockPaperScissorsGame {
    private int wins = 0;
    private int losses = 0;
    private int draws = 0;
 
    private enum Move {
        ROCK("rock"),
        PAPER("paper"),
        SCISSORS("scissors");
 
        private String value;
 
        Move(String value) {
            this.value = value;
        }
 
        public String getValue() {
            return value;
        }
    }
 
    private String getComputerMove() {
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        return Move.values()
        [randomNumber].getValue();
    }
 
    private boolean isPlayerWin(String playerMove, String computerMove) {
        return (playerMove.equals(Move.ROCK.getValue()) && computerMove.equals(Move.SCISSORS.getValue()))
                || (playerMove.equals(Move.SCISSORS.getValue()) && computerMove.equals(Move.PAPER.getValue()))
                || (playerMove.equals(Move.PAPER.getValue()) && computerMove.equals(Move.ROCK.getValue()));
    }
 
    public void playGame() {
        JFrame frame = new JFrame("Rock-Paper-Scissors Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());
 
        JButton rockButton = new JButton("Rock");
        JButton paperButton = new JButton("Paper");
        JButton scissorsButton = new JButton("Scissors");
 
        rockButton.addActionListener(e -> playRound(Move.ROCK.getValue()));
        paperButton.addActionListener(e -> playRound(Move.PAPER.getValue()));
        scissorsButton.addActionListener(e -> playRound(Move.SCISSORS.getValue()));
 
        frame.add(rockButton);
        frame.add(paperButton);
        frame.add(scissorsButton);
 
        frame.setVisible(true);
    }
 
    private void playRound(String playerMove) {
        String computerMove = getComputerMove();
 
        if (playerMove.equals(computerMove)) {
            draws++;
            JOptionPane.showMessageDialog(null, "It's a tie!");
        } else if (isPlayerWin(playerMove, computerMove)) {
            wins++;
            JOptionPane.showMessageDialog(null, "You won!");
        } else {
            losses++;
            JOptionPane.showMessageDialog(null, "You lost!");
        }
 
        System.out.println("Wins: " + wins + ", Losses: " + losses + ", Draws: " + draws);
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new RockPaperScissorsGame().playGame());
    }
}
