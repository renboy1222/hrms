/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.hrms.gui.dialog.au;


import com.aldrin.hrms.dao.impl.RoomStatusDAOImpl;
import com.aldrin.hrms.dao.impl.RoomTypeDAOImpl;
import com.aldrin.hrms.gui.JFrameHRMS;
import com.aldrin.hrms.model.RoomStatus;
import com.aldrin.hrms.model.RoomType;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author ALDRIN B. C.
 */
public class JDialogRoomStatusAU extends javax.swing.JDialog {

    /**
     * Creates new form JDialogRoomStatusAU
     */
    private JFrameHRMS jFrameHRMS;
    private RoomStatus roomStatus = new RoomStatus();
    static String title;
    private RoomStatusDAOImpl roomStatusDAOImpl = new RoomStatusDAOImpl();

    public JDialogRoomStatusAU(JFrameHRMS jFrameHRMS, boolean modal) {
        super(jFrameHRMS, modal);
        initComponents();
        setTitle("Add");
        this.title = "Add";
        jButton1.setIcon(new FlatSVGIcon("svg/save.svg", 24, 24));
        jTextFieldStatus.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "STATUS");
        jTextFieldDescription.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "DESCRIPTION");
    }

    public JDialogRoomStatusAU(JFrameHRMS jFrameCafSys, boolean modal, RoomStatus roomStatus, String title) {
        super(jFrameCafSys, modal);
        initComponents();
        setTitle(title);
        this.title = title;
        this.roomStatus = roomStatus;
        jButton1.setIcon(new FlatSVGIcon("svg/edit.svg", 24, 24));
        jButton1.setText(title);
        jTextFieldStatus.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "STATUS");
        jTextFieldDescription.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "DESCRIPTION");
        jTextFieldStatus.setText(roomStatus.getStatus());
        jTextFieldDescription.setText(roomStatus.getDescription());
    }

    public JDialogRoomStatusAU(JFrameHRMS jFrameHRMS, boolean modal, String title, RoomStatus roomStatus) {
        super(jFrameHRMS, modal);
        initComponents();
        setTitle(title);
        this.roomStatus = roomStatus;
        this.title = title;
        jButton1.setIcon(new FlatSVGIcon("svg/delete.svg", 24, 24));
        jButton1.setText(title);
        jTextFieldStatus.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "STATUS");
        jTextFieldDescription.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "DESCRIPTION");
        jTextFieldStatus.setText(roomStatus.getStatus());
        jTextFieldDescription.setText(roomStatus.getDescription());

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
        jTextFieldStatus = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDescription = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("STATUS:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 20, 80, 30));
        getContentPane().add(jTextFieldStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 250, 30));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 140, 30));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("DESCRIPTION:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 70, 80, 30));
        getContentPane().add(jTextFieldDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 250, 30));

        setSize(new java.awt.Dimension(373, 240));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.title.equals("Add")) {
            int response = JOptionPane.showConfirmDialog(jFrameHRMS, "Are you sure to save " + jTextFieldStatus.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.roomStatus.setId(null);
                this.roomStatus.setStatus(jTextFieldStatus.getText());
                this.roomStatus.setDescription(jTextFieldDescription.getText());
                roomStatusDAOImpl.addRoomStatus(roomStatus);
                this.dispose();
            }
        } else if (this.title.equals("Update")) {
            int response = JOptionPane.showConfirmDialog(jFrameHRMS, "Are you sure to update " + jTextFieldStatus.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.roomStatus.setStatus(jTextFieldStatus.getText());
                this.roomStatus.setDescription(jTextFieldDescription.getText());
                roomStatusDAOImpl.updateRoomStatus(roomStatus);
                this.dispose();
            }
        } else if (this.title.equals("Delete")) {
            int response = JOptionPane.showConfirmDialog(jFrameHRMS, "Are you sure to delete " + jTextFieldStatus.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                roomStatusDAOImpl.deleteRoomStatus(roomStatus);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldDescription;
    private javax.swing.JTextField jTextFieldStatus;
    // End of variables declaration//GEN-END:variables
    private File pictureFile = null;

}
