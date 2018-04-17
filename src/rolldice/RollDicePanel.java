// File:   rolldice/RollDicePanel.java
// Description: Panel of GUI, shows button and two dice.
// Author: Fred Swartz - 2006-11-30 - Placed in public domain.

// Modified by Tarek El Bardouni - 2017 - Placed in public domain.

package rolldice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//////////////////////////////////////////////////////////// class RollDicePanel
public class RollDicePanel extends JPanel {
    //======================================================= instance variables
    public static int Dice_Number;
    public final Die _leftDie;     // component for one die 
    public final Die _centerDie;
    public final Die _rightDie;

    //============================================================== constructor
    /** Create border layout panel with one button and two dice. */
    RollDicePanel() {
        //... Create the dice
        _leftDie  = new Die();
        _centerDie = new Die();
        _rightDie = new Die();
        
        //...Create the button to roll the dice
        JButton rollButton = new JButton("Renew Roll");
        rollButton.setFont(new Font("Sansserif", Font.PLAIN, 24));
        
        //... Add listener.
        rollButton.addActionListener(new RollListener());
        
        //... Layout components
        this.setLayout(new BorderLayout(5, 5));
        this.add(rollButton, BorderLayout.NORTH);
        switch (RollDice.Dice_Number)    {
        case 1:
            this.add(_centerDie , BorderLayout.CENTER);
        break;
        case 2:
            this.add(_leftDie , BorderLayout.WEST);
            this.add(_rightDie, BorderLayout.EAST);        
            break;
        case 3:
            this.add(_leftDie , BorderLayout.WEST);
            this.add(_centerDie, BorderLayout.CENTER);        
            this.add(_rightDie, BorderLayout.EAST);        
            break;
        default:
      System.out.println("Invalid Dice number; must be 1, 2 or 3");  
    }     
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
   
       
    ////////////////////////////////////////// inner listener class RollListener
    public class RollListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            _leftDie.roll();
            _centerDie.roll();
            _rightDie.roll();
        }
    }
}