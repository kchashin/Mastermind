package mastermind;

import core.Game;
import javax.swing.JOptionPane;
import userinterface.MasterMindUi;

public class MasterMind {
    
 public static void main(String[] args) {
        System.out.println("Welcome to MasterMind!");
        JOptionPane.showMessageDialog(null, "Let's Play MasterMind!");
        Game game = new Game();
          MasterMindUi ui = new MasterMindUi(game);
    }
} 

