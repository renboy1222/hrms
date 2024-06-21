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

}
