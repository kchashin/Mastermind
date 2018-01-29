/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import constants.Constants;
import core.Codemaker;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
/**
 *
 * @author Katarina Chashin
 */
public class CodemakerUi {
    private JPanel codemakerResponse;
    private JPanel secretCode;
    private JLabel[] secretLabels;
    private JLabel[][] responseLabels;
    private ImageIcon quiggle;
    
    private Codemaker codemaker;
    
    public CodemakerUi(Codemaker codemaker){
        this.codemaker = codemaker;
        initComponents();
    }
    
    private void initComponents(){
        initCodemakerResponse();
        initSecretCode();
    }
    
    private void initCodemakerResponse(){
        codemakerResponse = new JPanel();
        codemakerResponse.setBorder(BorderFactory.createTitledBorder("Codemaker Response"));
        codemakerResponse.setMinimumSize(new Dimension(150, 100));
        codemakerResponse.setPreferredSize(new Dimension(150,100));
        codemakerResponse.setLayout(new GridLayout(Constants.MAX_ATTEMPTS, Constants.MAX_PEGS));

        responseLabels = new JLabel[Constants.MAX_ATTEMPTS][Constants.MAX_PEGS];

        for (int row = 0; row < Constants.MAX_ATTEMPTS; row ++) {			
            for(int col = 0; col < Constants.MAX_PEGS; col++){

                responseLabels[row][col] = new JLabel();
                responseLabels[row][col].setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                // add the button to the UI
                codemakerResponse.add(responseLabels[row][col]);
            }
        }
    }
    
    private void initSecretCode(){
        secretCode = new JPanel();
        secretCode.setBorder(BorderFactory.createTitledBorder("Secret Code"));
        secretCode.setMinimumSize(new Dimension(200, 60));
        secretCode.setPreferredSize(new Dimension(200,60));
        secretCode.setAlignmentY(JPanel.TOP_ALIGNMENT);

        secretLabels = new JLabel[Constants.MAX_PEGS];
        
        quiggle = new ImageIcon( getClass().getResource("quiggle.jpg"));

        int counter = 0;
        
        for (JLabel label : secretLabels) {			
            label = new JLabel();
            label.setBackground(Color.LIGHT_GRAY);
            label.setIcon(imageResize(quiggle));

            secretCode.add(label);

            counter++;
        }

        JLabel space = new JLabel();
        space.setMinimumSize(new Dimension(100, 35));
        space.setPreferredSize(new Dimension(100, 35));
        secretCode.add(space);
        
        // add the check button
        JButton check = new JButton("Check");
        secretCode.add(check);
    }

    /**
     * @return the codemakerResponse
     */
    public JPanel getCodemakerResponse() {
        return codemakerResponse;
    }

    /**
     * @return the secretCode
     */
    public JPanel getSecretCode() {
        return secretCode;
    }
    
    private ImageIcon imageResize(ImageIcon icon){
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }
}
