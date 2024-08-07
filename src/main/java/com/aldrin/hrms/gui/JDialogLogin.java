/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.hrms.gui;


import com.aldrin.hrms.Hrms;
import com.aldrin.hrms.dao.impl.UserDAOImpl;
import com.aldrin.hrms.model.User;
import com.aldrin.hrms.util.LoginUser;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.event.KeyEvent;
import java.util.prefs.Preferences;

/**
 *
 * @author Java Programming with Aldrin
 */
public class JDialogLogin extends javax.swing.JDialog {

    /**
     * Creates new form JDialogLogin
     */
    private static final String USERNAME_PREF_KEY = "username";
    private static final String PASSWORD_PREF_KEY = "password";
    Preferences preferences = Preferences.userNodeForPackage(Hrms.class);

    public JDialogLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        // Check if username and password are stored in preferences
        jTextFieldUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Username");
        jPasswordFieldPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Password");

        //clear button
        jTextFieldUsername.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);

        //reveal button
        jPasswordFieldPassword.putClientProperty(FlatClientProperties.STYLE, "showRevealButton:true;" + "showCapsLock:true");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jCheckBoxRememberMe = new javax.swing.JCheckBox();
        jButtonLogin = new javax.swing.JButton();
        jLabelErrorMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Password");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 160, 440, 27));

        jTextFieldUsername.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 115, 440, 32));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 90, 440, 27));

        jPasswordFieldPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPasswordFieldPassword.setPreferredSize(new java.awt.Dimension(64, 32));
        jPasswordFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldPasswordKeyPressed(evt);
            }
        });
        getContentPane().add(jPasswordFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 185, 440, -1));

        jCheckBoxRememberMe.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jCheckBoxRememberMe.setText("Remember me");
        getContentPane().add(jCheckBoxRememberMe, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 230, 440, 30));

        jButtonLogin.setBackground(new java.awt.Color(4, 170, 109));
        jButtonLogin.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setText("Login");
        jButtonLogin.setPreferredSize(new java.awt.Dimension(72, 34));
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 270, 440, -1));

        jLabelErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelErrorMessage.setForeground(new java.awt.Color(204, 0, 0));
        jLabelErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabelErrorMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 40, 440, 30));

        setSize(new java.awt.Dimension(472, 355));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        login();

    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jPasswordFieldPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_jPasswordFieldPasswordKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JCheckBox jCheckBoxRememberMe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelErrorMessage;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
    private UserDAOImpl userDAOImpl = new UserDAOImpl();

    private void login() {
        String username = jTextFieldUsername.getText();
        String password = new String(jPasswordFieldPassword.getPassword());
        boolean remember = jCheckBoxRememberMe.isSelected();

        // Validate login
        User user = new User();
        String storedUsername = preferences.get(USERNAME_PREF_KEY, null);
        String storedPassword = preferences.get(PASSWORD_PREF_KEY, null);
        user.setUsername(storedUsername);
        user.setPassword(storedPassword);
        //  login for preferences
        if (userDAOImpl.loginUser(user) != null) {
            LoginUser logInUser = new LoginUser();
            user = userDAOImpl.loginUser(user);
            logInUser.setUser(user);
            dispose();
            // login for jdialog
        }
        user.setUsername(jTextFieldUsername.getText());
        user.setPassword(jPasswordFieldPassword.getText());
        if (userDAOImpl.loginUser(user) != null) {
            if (remember) {
                preferences.put(USERNAME_PREF_KEY, username);
                preferences.put(PASSWORD_PREF_KEY, password);
            }
            dispose();
        } else {
            jLabelErrorMessage.setText("Please check your username and password and try again.");
            jTextFieldUsername.putClientProperty("JComponent.outline", "error");
            jPasswordFieldPassword.putClientProperty("JComponent.outline", "error");
        }
    }

}
