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
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampValidator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Timestamp Validator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Mask for timestamp format (YYYY-MM-DD HH:MM:SS)
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("####-##-## ##:##:##");
            formatter.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Formatted text field for timestamp input
        JFormattedTextField timestampField = new JFormattedTextField(formatter);
        timestampField.setColumns(16);
        frame.add(new JLabel("Enter Timestamp (YYYY-MM-DD HH:MM:SS):"));
        frame.add(timestampField);

        // Button to validate timestamp
        JButton validateButton = new JButton("Validate");
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String timestamp = timestampField.getText();
                if (isValidTimestamp(timestamp)) {
                    JOptionPane.showMessageDialog(frame, "Valid Timestamp: " + timestamp);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Timestamp Format!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.add(validateButton);

        frame.pack();
        frame.setVisible(true);
    }

    public static boolean isValidTimestamp(String timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        try {
            Date parsedDate = dateFormat.parse(timestamp);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}

