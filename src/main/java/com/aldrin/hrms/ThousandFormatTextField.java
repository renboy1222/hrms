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
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class ThousandFormatTextField {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Thousand Format JTextField");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.setLayout(new FlowLayout());

            // Create a NumberFormat instance for number formatting
            NumberFormat numberFormat = NumberFormat.getNumberInstance();
            NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
            numberFormatter.setValueClass(Long.class); // Specify the value class
            numberFormatter.setAllowsInvalid(false);   // Only allow valid numbers
            numberFormatter.setMinimum(0L);            // Minimum value
            numberFormatter.setMaximum(Long.MAX_VALUE);// Maximum value

            // Create a JFormattedTextField with the NumberFormatter
            JFormattedTextField formattedTextField = new JFormattedTextField(numberFormatter);
            formattedTextField.setColumns(20);
            System.out.println("formatted:"+formattedTextField.getText());

            // Add the formatted text field to the frame
            frame.add(formattedTextField);

            frame.setVisible(true);
        });
    }
}

