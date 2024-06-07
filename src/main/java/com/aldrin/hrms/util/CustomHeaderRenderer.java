/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms.util;

/**
 *
 * @author Java Programming with Aldrin
 */
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class CustomHeaderRenderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Set custom background colors for each column header
        switch (column) {
            case 0:
                setBackground(Color.RED);
                break;
            case 1:
                setBackground(Color.GREEN);
                break;
            case 2:
                setBackground(Color.BLUE);
                break;
            case 3:
                setBackground(Color.green);
                break;
            case 4:
                setBackground(Color.GRAY);
                break;
//            default:
//                setBackground(Color.BLACK);
//                break;
        }

        setForeground(Color.WHITE); // Set text color to white for contrast
        return this;
    }

    public static void main(String[] args) {
        // Run the GUI creation in the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom JTable Header Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Sample data for the table
            Object[][] data = {
                {"John", "Doe", "john@example.com"},
                {"Jane", "Doe", "jane@example.com"},
                {"Max", "Mustermann", "max@example.com"}
            };

            // Column names
            String[] columnNames = {"First Name", "Last Name", "Email"};

            // Create table with data and column names
            JTable table = new JTable(data, columnNames);

            // Set the custom renderer for the table header
            JTableHeader header = table.getTableHeader();
            header.setDefaultRenderer(new CustomHeaderRenderer());
            header.setPreferredSize(new Dimension(header.getPreferredSize().width, 30)); // Optional: Adjust header height

            // Add the table to a scroll pane and then to the frame
            frame.add(new JScrollPane(table), BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null); // Center the frame
            frame.setVisible(true);
        });
    }
}
