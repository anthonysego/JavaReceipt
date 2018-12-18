/*
Program Name:           FestivalGUI
Author:                 Anthony Sego
Date:                   4/21/2018
Purpose of Program:     Driver for FestivalPanel.java
                        Sets up and displays panel     */

package fallfestivalgui;

import javax.swing.JFrame;

public class FallFestivalGUI {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Festival");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        FestivalPanel panel = new FestivalPanel();
        frame.getContentPane().add(panel);
        
        frame.pack();
        frame.setVisible(true);
    }
    
}
