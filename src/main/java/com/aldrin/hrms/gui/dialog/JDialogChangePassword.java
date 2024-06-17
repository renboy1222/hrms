/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.hrms.gui.dialog;


import com.aldrin.hrms.dao.impl.UserDAOImpl;
import com.aldrin.hrms.model.User;
import com.aldrin.hrms.util.LoginUser;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Java Programming with Aldrin
 */
public class JDialogChangePassword extends javax.swing.JDialog {

    private static boolean currentPassword = false;
    private LoginUser loginUser = new LoginUser();
    private static boolean reTypePassword = false;
    private com.aldrin.hrms.gui.JFrameHRMS jFrameHRMS;

    public JDialogChangePassword(com.aldrin.hrms.gui.JFrameHRMS parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.jFrameHRMS =parent;
        jTextFieldUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Username");
        jPasswordFieldCurrentPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Current password");
        jPasswordFieldNewPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "New password");
        jPasswordFieldReTypePassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Re-type new password");

        jTextFieldUsername.setText(loginUser.getUser().getUsername());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPasswordFieldReTypePassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPasswordFieldCurrentPassword = new javax.swing.JPasswordField();
        jPasswordFieldNewPassword = new javax.swing.JPasswordField();
        jButtonChangePassword = new javax.swing.JButton();
        jLabelErrorMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CHANGE PASSWORD");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Re-type new password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 240, 340, 20));

        jTextFieldUsername.setEditable(false);
        jTextFieldUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldUsername.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldUsername.setFocusable(false);
        getContentPane().add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, 340, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Username");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 60, 340, 20));

        jPasswordFieldReTypePassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPasswordFieldReTypePassword.setForeground(new java.awt.Color(51, 51, 51));
        jPasswordFieldReTypePassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldReTypePasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldReTypePasswordKeyReleased(evt);
            }
        });
        getContentPane().add(jPasswordFieldReTypePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 260, 340, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Current password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 120, 340, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("New password");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 340, 20));

        jPasswordFieldCurrentPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPasswordFieldCurrentPassword.setForeground(new java.awt.Color(51, 51, 51));
        jPasswordFieldCurrentPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldCurrentPasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldCurrentPasswordKeyReleased(evt);
            }
        });
        getContentPane().add(jPasswordFieldCurrentPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 140, 340, 30));

        jPasswordFieldNewPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPasswordFieldNewPassword.setForeground(new java.awt.Color(51, 51, 51));
        jPasswordFieldNewPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldNewPasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldNewPasswordKeyReleased(evt);
            }
        });
        getContentPane().add(jPasswordFieldNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 200, 340, 30));

        jButtonChangePassword.setBackground(new java.awt.Color(4, 170, 109));
        jButtonChangePassword.setIcon(new FlatSVGIcon("svg/save.svg",24,24));
        jButtonChangePassword.setText("Save");
        jButtonChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangePasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonChangePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 313, 340, 30));

        jLabelErrorMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelErrorMessage.setForeground(new java.awt.Color(204, 0, 0));
        jLabelErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabelErrorMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 20, 340, 30));

        setSize(new java.awt.Dimension(368, 390));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordFieldReTypePasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldReTypePasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            userAccessAccount();
        }
    }//GEN-LAST:event_jPasswordFieldReTypePasswordKeyPressed

    private void jPasswordFieldCurrentPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldCurrentPasswordKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldCurrentPasswordKeyPressed

    private void jPasswordFieldNewPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldNewPasswordKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldNewPasswordKeyPressed

    private void jPasswordFieldCurrentPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldCurrentPasswordKeyReleased
        if (jPasswordFieldCurrentPassword.getText().equals(loginUser.getUser().getPassword().toString())) {
            jPasswordFieldCurrentPassword.putClientProperty("JComponent.outline", null);
            setCurrentPassword(true);
            validateFields();
            jLabelErrorMessage.setText("");
        } else {
            setCurrentPassword(false);
            validateFields();
            jLabelErrorMessage.setText("Current password did not match.");
            jPasswordFieldCurrentPassword.putClientProperty("JComponent.outline", "error");
        }
    }//GEN-LAST:event_jPasswordFieldCurrentPasswordKeyReleased

    private void jPasswordFieldNewPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldNewPasswordKeyReleased
        if (!jPasswordFieldNewPassword.getText().toString().equals(jPasswordFieldCurrentPassword.getText().toString())) {
            jPasswordFieldNewPassword.putClientProperty("JComponent.outline", null);
            setReTypePassword(true);
            validateFields();
            jLabelErrorMessage.setText("");
        } else {
            setReTypePassword(false);
            validateFields();
            jPasswordFieldNewPassword.putClientProperty("JComponent.outline", "error");
            jLabelErrorMessage.setText("Current password is not allowed.");

        }
    }//GEN-LAST:event_jPasswordFieldNewPasswordKeyReleased

    private void jPasswordFieldReTypePasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldReTypePasswordKeyReleased
        if (jPasswordFieldNewPassword.getText().toString().equals(jPasswordFieldReTypePassword.getText().toString())) {
            jPasswordFieldReTypePassword.putClientProperty("JComponent.outline", null);
            setReTypePassword(true);
            validateFields();
            jLabelErrorMessage.setText("");
        } else {
            setReTypePassword(false);
            validateFields();
            jPasswordFieldReTypePassword.putClientProperty("JComponent.outline", "error");
            jLabelErrorMessage.setText("Error input please try again.");

        }
    }//GEN-LAST:event_jPasswordFieldReTypePasswordKeyReleased

    private void jButtonChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangePasswordActionPerformed
        UserDAOImpl userAccountDAOImpl = new UserDAOImpl();
        User userAccount = new User();
        userAccount.setId(loginUser.getUser().getId());
        userAccount.setPassword(jPasswordFieldReTypePassword.getText());
        int response = JOptionPane.showConfirmDialog(this, "Are you sure to change your password?", "Change password confirmation", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            if (userAccountDAOImpl.changePassword(userAccount) == true) {
                JOptionPane.showMessageDialog(jFrameHRMS, "Password is successfully change.", "Message", JOptionPane.PLAIN_MESSAGE);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButtonChangePasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonChangePassword;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelErrorMessage;
    private javax.swing.JPasswordField jPasswordFieldCurrentPassword;
    private javax.swing.JPasswordField jPasswordFieldNewPassword;
    private javax.swing.JPasswordField jPasswordFieldReTypePassword;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
private void validateFields() {
        if (isCurrentPassword() == true && isReTypePassword() == true) {
            jButtonChangePassword.setEnabled(true);
        } else {
            jButtonChangePassword.setEnabled(false);
        }
    }

    /**
     * @return the reTypePassword
     */
    public static boolean isReTypePassword() {
        return reTypePassword;
    }

    /**
     * @param aReTypePassword the reTypePassword to set
     */
    public static void setReTypePassword(boolean aReTypePassword) {
        reTypePassword = aReTypePassword;
    }

    /**
     * @return the currentPassword
     */
    public static boolean isCurrentPassword() {
        return currentPassword;
    }

    /**
     * @param aCurrentPassword the currentPassword to set
     */
    public static void setCurrentPassword(boolean aCurrentPassword) {
        currentPassword = aCurrentPassword;
    }
}
