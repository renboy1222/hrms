/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.hrms.gui.dialog.au;

import com.aldrin.hrms.dao.impl.DurationDAOImpl;
import com.aldrin.hrms.gui.JFrameHRMS;
import com.aldrin.hrms.model.Duration;
import com.aldrin.hrms.util.NumberInput;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author ALDRIN B. C.
 */
public class JDialogDurationAU extends javax.swing.JDialog {

    /**
     * Creates new form JDialogRoomTypeAU
     */
    private JFrameHRMS jFrameHRMS;
    private Duration duration = new Duration();
    static String title;
    private DurationDAOImpl durationDAOImpl = new DurationDAOImpl();

    public JDialogDurationAU(JFrameHRMS jFrameHRMS, boolean modal) {
        super(jFrameHRMS, modal);
        initComponents();
        setTitle("Add");
        this.title = "Add";
        new NumberInput().intValidator(jTextFieldMinutes);
        jButton1.setIcon(new FlatSVGIcon("svg/save.svg", 24, 24));
        jTextFieldDuration.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "DURATION");
        jTextFieldMinutes.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "MINUTES");
    }

    public JDialogDurationAU(JFrameHRMS jFrameCafSys, boolean modal, Duration duration, String title) {
        super(jFrameCafSys, modal);
        initComponents();
        setTitle(title);
        this.title = title;
        this.duration = duration;
        new NumberInput().intValidator(jTextFieldMinutes);
        jButton1.setIcon(new FlatSVGIcon("svg/edit.svg", 24, 24));
        jButton1.setText(title);
        jTextFieldDuration.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "DURATION");
        jTextFieldDuration.setText(duration.getDuration());
        jTextFieldMinutes.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "MINUTES");
        jTextFieldMinutes.setText(String.valueOf(duration.getMinutes()));
    }

    public JDialogDurationAU(JFrameHRMS jFrameHRMS, boolean modal, String title, Duration duration) {
        super(jFrameHRMS, modal);
        initComponents();
        setTitle(title);
        this.duration = duration;
        this.title = title;
        new NumberInput().intValidator(jTextFieldMinutes);
        jButton1.setIcon(new FlatSVGIcon("svg/delete.svg", 24, 24));
        jButton1.setText(title);
        jTextFieldDuration.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "DURATION");
        jTextFieldDuration.setText(duration.getDuration());
        jTextFieldMinutes.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "MINUTES");
        jTextFieldMinutes.setText(String.valueOf(duration.getMinutes()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDuration = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldMinutes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("MINUTES:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 60, 80, 30));
        getContentPane().add(jTextFieldDuration, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 250, 30));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 140, 30));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("DURATION:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 20, 80, 30));
        getContentPane().add(jTextFieldMinutes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 250, 30));

        setSize(new java.awt.Dimension(369, 199));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.title.equals("Add")) {
            int response = JOptionPane.showConfirmDialog(jFrameHRMS, "Are you sure to save " + jTextFieldDuration.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.duration.setId(null);
                this.duration.setDuration(jTextFieldDuration.getText());
                this.duration.setMinutes(Integer.parseInt(jTextFieldMinutes.getText()));
                durationDAOImpl.addDuration(duration);
                this.dispose();
            }
        } else if (this.title.equals("Update")) {
            int response = JOptionPane.showConfirmDialog(jFrameHRMS, "Are you sure to update " + jTextFieldDuration.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.duration.setDuration(jTextFieldDuration.getText());
                this.duration.setMinutes(Integer.parseInt(jTextFieldMinutes.getText()));
                durationDAOImpl.updateDuration(duration);
                this.dispose();
            }
        } else if (this.title.equals("Delete")) {
            int response = JOptionPane.showConfirmDialog(jFrameHRMS, "Are you sure to delete " + jTextFieldDuration.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                durationDAOImpl.deleteDuration(duration);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextFieldDuration;
    private javax.swing.JTextField jTextFieldMinutes;
    // End of variables declaration//GEN-END:variables
    private File pictureFile = null;

}
