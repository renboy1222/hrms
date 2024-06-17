/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms;

/**
 *
 * @author Java Programming with Aldrin
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonWithPopupMenu {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("JButton with JPopupMenu Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null); // Use absolute positioning for simplicity

        // Create a button
        JButton button = new JButton("Click Me");
        button.setBounds(100, 50, 100, 30); // Set the position and size of the button
        frame.add(button);

        // Create a popup menu
        JPopupMenu popupMenu = new JPopupMenu();
        
        // Create and add menu items to the popup menu
        JMenuItem menuItem1 = new JMenuItem("Option 1");
        JMenuItem menuItem2 = new JMenuItem("Option 2");
        JMenuItem menuItem3 = new JMenuItem("Option 3");
        
        popupMenu.add(menuItem1);
        popupMenu.add(menuItem2);
        popupMenu.add(menuItem3);

        // Add action listeners to menu items
        menuItem1.addActionListener(e -> System.out.println("Option 1 selected"));
        menuItem2.addActionListener(e -> System.out.println("Option 2 selected"));
        menuItem3.addActionListener(e -> System.out.println("Option 3 selected"));

        // Add an action listener to the button to show the popup menu
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the popup menu at the button's location
                popupMenu.show(button, button.getWidth() / 2, button.getHeight() / 2);
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}

