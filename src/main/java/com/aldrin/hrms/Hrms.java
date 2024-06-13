/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.aldrin.hrms;

import com.aldrin.hrms.gui.JFrameHRMS;
import com.aldrin.hrms.gui.JFrameHRMS;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Java Programming with Aldrin
 */
public class Hrms {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FlatLightLaf.setup();
            UIManager.put("Button.arc", 8);//JButton
            UIManager.put("ProgressBar.arc", 999);//JProgressBar
            UIManager.put("TextComponent.arc", 8);//JTextField,JPasswordField,JFormattedTextField
            UIManager.put("CheckBox", 999);//JCheckBox
            UIManager.put("Component.arc", 8);//JComboBox,JSpinner

            UIManager.put("Component.innerFocusWidth", 2);//JComboBox, JTextField,JPasswordField,JFormattedTextField,JSpinner
            UIManager.put("Button.innerFocusWidth", 2);//JButton

            System.setProperty("flatlaf.menuBarEmbedded", "false");
            JFrameHRMS hrms = new JFrameHRMS();
            hrms.setVisible(true);
        });
    }
}
