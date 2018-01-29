/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.Color;
import java.util.ArrayList;
import constants.Constants;
import java.util.Scanner;

/**
 *
 * @author Kchashin
 */
public class Codebreaker implements ICodebreaker{


    private ArrayList<Color> codebreakerAttempt;

    
    public Codebreaker(){
      
        codebreakerAttempt = new ArrayList<>();
    }
    
    public void removeAll() {
        codebreakerAttempt.clear();
        
    }  
    
    
    private void consoleAttempt(){
        // reset the codebreakerAttempt
        codebreakerAttempt.removeAll(codebreakerAttempt);
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nEnter your colors in left to right order\n" +
            "Use BLUE, BLACK, ORANGE, WHITE, YELLOW, RED, GREEN, PINK:");
        
        while(codebreakerAttempt.size() < Constants.MAX_PEGS){
            String guess = scanner.next();

            switch(guess.toUpperCase()){
                case "BLUE":
                    System.out.println("You enteted blue");
                    codebreakerAttempt.add(Color.BLUE);
                    break;
                case "BLACK":
                    System.out.println("You enteted black");
                    codebreakerAttempt.add(Color.BLACK);
                    break;
                case "GREEN":
                    System.out.println("You enteted green");
                    codebreakerAttempt.add(Color.GREEN);
                    break;
                case "ORANGE":
                    System.out.println("You enteted orange");
                    codebreakerAttempt.add(Color.ORANGE);
                    break;
                case "PINK":
                    System.out.println("You enteted pink");
                    codebreakerAttempt.add(Color.PINK);
                    break;
                case "RED":
                    System.out.println("You enteted red");
                    codebreakerAttempt.add(Color.RED);
                    break;
                case "YELLOW":
                    System.out.println("You enteted yellow");
                    codebreakerAttempt.add(Color.YELLOW);
                    break;
                case "WHITE":
                    System.out.println("You enteted white");
                    codebreakerAttempt.add(Color.WHITE);
                    break;
                default:
                    System.out.println("Invalid color choice, try again");
                    break;
            }
            
            if(codebreakerAttempt.size() < Constants.MAX_PEGS)
                System.out.println("Next color");
        }   
        
        System.out.println("Codebreaker's attempt");
        
        for(Color color : codebreakerAttempt){
            System.out.println(color);
        }
    }
    /**
     * @return the codebreakerAttempt
     */
    public ArrayList<Color> getCodebreakerAttempt() {
    
        
        return codebreakerAttempt;
    }

    /**
     * @param codebreakerAttempt the codebreakerAttempt to set
     */
    public void setCodebreakerAttempt(ArrayList<Color> codebreakerAttempt) {
        this.codebreakerAttempt = codebreakerAttempt;
    }
    
    @Override
    public void checkCode(ArrayList<Color> attempt) {
    }

   
   
}