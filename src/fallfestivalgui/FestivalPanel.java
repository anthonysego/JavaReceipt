/*
Program Name:           FestivalGUI
Author:                 Anthony Sego
Date:                   4/21/2018
Purpose of Program:     Use java GUI to recreate a version of the festival receipt program
                        use JTextFields to collect data, JButton to use collected data
                        and JLabel to output data calculated from JTextFields
                        Use actionListeners with buttons*/


package fallfestivalgui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FestivalPanel extends JPanel {

    private JLabel nameLabel, dateLabel, itemsLabel, codeLabel;
    private JTextField fullName, dateOfPurchase, numItems, grouponCode;
    
    private JLabel grouponItemsLabel, itemsLeftLabel, amountDueLabel;
    
    private JButton submit, clear;
 
    //----------------------------------------------------------
    //Set up panel with all JTextFields, JLabels, and JButtons
    //----------------------------------------------------------
    public FestivalPanel()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        nameLabel = new JLabel ("Enter Full Name: ");
        fullName = new JTextField (5);
        
        dateLabel = new JLabel ("Enter date: ");
        dateOfPurchase = new JTextField (5);
        
        itemsLabel = new JLabel ("Enter number of items: ");
        numItems = new JTextField (5);
        
        codeLabel = new JLabel ("Enter Groupon Code: ");
        grouponCode = new JTextField (5);
        
        submit = new JButton ("Submit");
        submit.addActionListener(new SubmitListener());
        
        clear = new JButton ("Clear");
        clear.addActionListener(new ClearListener());
        
        grouponItemsLabel = new JLabel ("");
        itemsLeftLabel = new JLabel ("");
        amountDueLabel = new JLabel ("");
        
        add(nameLabel);
        add(fullName);
        add(dateLabel);
        add(dateOfPurchase);
        add(itemsLabel);
        add(numItems);
        add(codeLabel);
        add(grouponCode);
        add(submit);
        add(clear);
        add(grouponItemsLabel);
        add(itemsLeftLabel);
        add(amountDueLabel);
        
        
        setPreferredSize(new Dimension(400, 500));
        
    }
    //----------------------------------------------------------
    //ActionListener and actionPerformed for submit button
    //----------------------------------------------------------
    private class SubmitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {   
            //----------------------------------------------------------
            //get all text from JTextFields
            //----------------------------------------------------------
            String name =  fullName.getText();
            String date =  dateOfPurchase.getText();
            String items = numItems.getText();
            String code = grouponCode.getText();
            
            //----------------------------------------------------------
            //instantiate variables for calculaions.  ParseInt for number of items
            //----------------------------------------------------------
            int itemsLeft = Integer.parseInt(items);
            int grouponItems = 0;
            int totalPrice = 0;
            final int PRICE_OF_ITEMS = 35;
            
            //----------------------------------------------------------
            //if statements depending on which groupon code is entered
            //total amount of groupon items and total price minus the groupon items
            //----------------------------------------------------------
            
            if(code.equals("OneItem2017"))
            {
                itemsLeft = itemsLeft - 1;
                totalPrice = itemsLeft * PRICE_OF_ITEMS;
                grouponItems = 1;
                
            }
            

            else if(code.equals("TwoItems2017"))
            {
                itemsLeft = itemsLeft - 2;
                totalPrice = itemsLeft * PRICE_OF_ITEMS;
                grouponItems = 2;
            }
            
            else
            {
                totalPrice = itemsLeft * PRICE_OF_ITEMS;
            }
            
            //----------------------------------------------------------
            //set text for output labels
            //----------------------------------------------------------
            grouponItemsLabel.setText ("Items paid for with groupon Code: " + Integer.toString(grouponItems));
            itemsLeftLabel.setText("Items left to pay for: " + Integer.toString(itemsLeft));
            amountDueLabel.setText("Amount Due: " + (Integer.toString(totalPrice)));
            
            
            
        }
    }
    
    //----------------------------------------------------------
    //Action listener for clear button.  Clears all fields and labels
    //----------------------------------------------------------
    private class ClearListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {   
            fullName.setText(""); 
            dateOfPurchase.setText("");
            numItems.setText("");
            grouponCode.setText("");
            grouponItemsLabel.setText ("");
            itemsLeftLabel.setText("");
            amountDueLabel.setText("");
            
        }
    }
    
}
