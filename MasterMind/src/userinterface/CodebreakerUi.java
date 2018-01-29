/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import constants.Constants;
import static constants.Constants.MAX_PEGS;
import core.Codebreaker;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Katarina Chashin
 */

public class CodebreakerUi 
{
    private JPanel codebreakerAttempt;
    private JPanel codebreakerColors;
    private RoundButton[] buttons;
    private RoundButton[][] attempts;
    
    Color colorSelected;
    
    private Codebreaker codebreaker;
    
    public CodebreakerUi(Codebreaker codebreaker){
        this.codebreaker = codebreaker;
        initComponents();
    }
    
    private void initComponents(){
        initCodebreakerColors();
        initCodebreakerAttempt();
    }
    
    private void initCodebreakerColors(){
        codebreakerColors = new JPanel();
        codebreakerColors.setBorder(BorderFactory.createTitledBorder("Codebreaker Colors"));
        codebreakerColors.setMinimumSize(new Dimension(200, 65));
        codebreakerColors.setPreferredSize(new Dimension(200,65));

        buttons = new RoundButton[Constants.COLORS];

        int counter = 0;

        for (RoundButton button : buttons) {			

            button = new RoundButton();
            Color color = Constants.codeColors.get(counter);
            button.setBackground(color);
            button.putClientProperty("color", color);

            if(color == Color.BLUE)
                button.setToolTipText("BLUE");
            else if(color == Color.BLACK)
                button.setToolTipText("BLACK");
            else if(color == Color.GREEN)
                button.setToolTipText("GREEN");
            else if(color == Color.ORANGE)
                button.setToolTipText("ORANGE");
            else if(color == Color.PINK)
                button.setToolTipText("PINK");
            else if(color == Color.RED)
                button.setToolTipText("RED");            
            else if(color == Color.YELLOW)
                button.setToolTipText("YELLOW");
            else if(color == Color.WHITE)
                button.setToolTipText("WHITE");

         button.addActionListener(new ColoredButtons());

            codebreakerColors.add(button);

            counter++;
            
        }	

    }
    
    private void initCodebreakerAttempt(){
        codebreakerAttempt = new JPanel();
        codebreakerAttempt.setBorder(BorderFactory.createTitledBorder("Codebreaker Attempt"));
        codebreakerAttempt.setMinimumSize(new Dimension(100, 100));
        codebreakerAttempt.setPreferredSize(new Dimension(100, 100));
        
        // set the layout manager to use GridLayout
        codebreakerAttempt.setLayout(new GridLayout(Constants.MAX_ATTEMPTS, Constants.MAX_PEGS));
        
        // instantiate the Array with the size
        attempts = new RoundButton[Constants.MAX_ATTEMPTS][Constants.MAX_PEGS];
        
        // create the array of JButtons for the code breaker's attempts
        for (int row = 0; row < Constants.MAX_ATTEMPTS; row ++) {			
            for(int col = 0; col < Constants.MAX_PEGS; col++){
                // create the buttons
                attempts[row][col] = new RoundButton();
                attempts[row][col].putClientProperty("row", row);
                attempts[row][col].addActionListener(new RoundButtons());
                
               
                if(row != (Constants.MAX_ATTEMPTS - 1))
                    attempts[row][col].setEnabled(false);
                
            
                codebreakerAttempt.add(attempts[row][col]);
                
            }
             

        }
            
    }

    /**
     * @return the codebreakerAttempt
     */
    public JPanel getCodebreakerAttempt() 
    {
        
        return codebreakerAttempt;
    }

    /**
     * @return the codebreakerColors
     */
    public JPanel getCodebreakerColors() 
    {
        
        return codebreakerColors;
    }
    
    private class ColoredButtons implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            RoundButton sourceButton = (RoundButton)ae.getSource();
            
            colorSelected = (Color)sourceButton.getClientProperty("color");
        }
    }
    private class RoundButtons implements ActionListener{
        
        @Override
        
        public void actionPerformed(ActionEvent be) {
            RoundButton placementButton = (RoundButton)be.getSource();
            if(codebreaker.getCodebreakerAttempt().contains(colorSelected) == false){
                placementButton.setBackground(colorSelected);
                codebreaker.getCodebreakerAttempt().add(colorSelected);
            }
            if(codebreaker.getCodebreakerAttempt().size() == 4){
               
               
                int row = (int) placementButton.getClientProperty("row");
                 enableDisableButtons(row);
            }
            
            
        }
        
    }
    public void clearBoard() {
         for(int i=0;i<10;i++){
            for(int j=0; j<4;j++){
            attempts[i][j].setBackground(null);
            
                if (i == 9)
                    attempts[i][j].setEnabled(true);
                else
                    attempts[i][j].setEnabled(false);
        }
    }
       codebreaker.removeAll();
        
    }
    private void enableDisableButtons(int row){
       
      for (int col = 0; col < Constants.MAX_PEGS; col++){
          attempts[row][col].setEnabled(false);
          if(row != 0) {
              attempts[row - 1][col].setEnabled(true);
              
          }
          codebreaker.removeAll();
          
      }

    }
    
}