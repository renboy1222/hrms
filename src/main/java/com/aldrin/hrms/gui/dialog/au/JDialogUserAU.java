/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.hrms.gui.dialog.au;




import com.aldrin.hrms.Hrms;
import com.aldrin.hrms.dao.impl.RoleDAOImpl;
import com.aldrin.hrms.dao.impl.UserDAOImpl;
import com.aldrin.hrms.gui.JFrameHRMS;
import com.aldrin.hrms.model.Role;
import com.aldrin.hrms.model.User;
import com.aldrin.hrms.util.ComboBoxList;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ALDRIN B. C.
 */
public class JDialogUserAU extends javax.swing.JDialog {

    private RoleDAOImpl roleDAOImpl = new RoleDAOImpl();
    private UserDAOImpl studentDAOImpl = new UserDAOImpl();
    private JFrameHRMS jFrameCafSys;

    /**
     * Creates new form JDialogStudent
     */
    private User userAccount = new User();
    static String title = "";

    public JDialogUserAU(JFrameHRMS jFrameHRMS, boolean modal) {
        super(jFrameHRMS, modal);
        initComponents();
        this.jFrameCafSys =jFrameHRMS;
        setTitle("New user account");
        this.title = "New";
        jTextFieldFirstname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "FIRST NAME");
        jTextFieldSurname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "SURNAME");
        jTextFieldUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "USERNAME");
        jTextFieldPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "PASSWORD");
        comboBoxUserAccount();
        jCheckBoxActive.setSelected(true);
        jButton1.setIcon(new FlatSVGIcon("svg/save.svg",24,24));
        

    }

    public JDialogUserAU(JFrameHRMS jFrameHRMS, boolean modal, User userAccount, String title) {
        super(jFrameHRMS, modal);
        initComponents();
        setTitle("Update user account");
        this.userAccount = userAccount;
        this.title = title;
        JFrameHRMS hrms = new JFrameHRMS();
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(187, 187, 187));
        jTextFieldFirstname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "First name");
        jTextFieldSurname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Surname");
        jTextFieldUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Username");
        jTextFieldPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Password");
        comboBoxUserAccount();
        jTextFieldFirstname.setText(userAccount.getFirstname());
        jTextFieldSurname.setText(userAccount.getSurname());
        jTextFieldUsername.setText(userAccount.getUsername());
        jTextFieldPassword.setText(userAccount.getPassword());
        jCheckBoxActive.setSelected(userAccount.getActive());
        for (ComboBoxList a : this.roleDAOImpl.getList()) {
            a.setSelectedId(roleDAOImpl.getList(), String.valueOf(userAccount.getRole().getId()), jComboBoxRole);
        }
        displayPicture(userAccount);
        jButton1.setIcon(new FlatSVGIcon("svg/edit.svg",24,24));

    }

    public JDialogUserAU(JFrameHRMS jFrameCafSys, boolean modal, String title, User userAccount) {
        super(jFrameCafSys, modal);
        initComponents();
        setTitle("Delete user account");
        this.userAccount = userAccount;
        this.title = title;
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(187, 187, 187));
        jTextFieldFirstname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "FIRST NAME");
        jTextFieldSurname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "SURNAME");
        jTextFieldUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "USERNAME");
        jTextFieldPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "PASSWORD");
        comboBoxUserAccount();
        jTextFieldFirstname.setText(userAccount.getFirstname());
        jTextFieldSurname.setText(userAccount.getSurname());
        jTextFieldUsername.setText(userAccount.getUsername());
        jTextFieldPassword.setText(userAccount.getPassword());
        jCheckBoxActive.setSelected(userAccount.getActive());
        for (ComboBoxList a : this.roleDAOImpl.getList()) {
            a.setSelectedId(roleDAOImpl.getList(), String.valueOf(userAccount.getRole().getId()), jComboBoxRole);
        }
        displayPicture(userAccount);
        jButton1.setIcon(new FlatSVGIcon("svg/delete.svg",24,24));
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
        jTextFieldFirstname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldSurname = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelPicture = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldPassword = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBoxRole = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCheckBoxActive = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("FIRST NAME:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 20, 100, 30));

        jTextFieldFirstname.setPreferredSize(new java.awt.Dimension(64, 30));
        getContentPane().add(jTextFieldFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 220, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 220, 80, 30));

        jTextFieldSurname.setPreferredSize(new java.awt.Dimension(64, 30));
        getContentPane().add(jTextFieldSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 220, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PHOTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 102, 153))); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabelPicture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPictureMouseClicked(evt);
            }
        });
        jPanel2.add(jLabelPicture, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(210, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 210, 230));

        jTextFieldPassword.setMinimumSize(new java.awt.Dimension(64, 32));
        jTextFieldPassword.setPreferredSize(new java.awt.Dimension(64, 32));
        getContentPane().add(jTextFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 220, -1));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 168, 32));

        jComboBoxRole.setPreferredSize(new java.awt.Dimension(72, 32));
        getContentPane().add(jComboBoxRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 220, 30));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("SURNAME:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 60, 100, 30));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("ROLE:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 100, 100, 30));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("USERNAME:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 140, 100, 30));

        jTextFieldUsername.setMinimumSize(new java.awt.Dimension(64, 32));
        jTextFieldUsername.setPreferredSize(new java.awt.Dimension(64, 32));
        getContentPane().add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 220, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("PASSWORD:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 100, 30));

        jCheckBoxActive.setText("ACTIVE");
        getContentPane().add(jCheckBoxActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 220, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 251, 550, 1));

        setSize(new java.awt.Dimension(589, 347));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.title.equals("New")) {
            int response = JOptionPane.showConfirmDialog(jFrameCafSys, "Are you sure to save " + jTextFieldFirstname.getText() + " " + jTextFieldSurname.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.userAccount.setFirstname(jTextFieldFirstname.getText());
                this.userAccount.setSurname(jTextFieldSurname.getText());
                this.userAccount.setUsername(jTextFieldUsername.getText());
                this.userAccount.setPassword(jTextFieldPassword.getText());
                this.userAccount.setActive(jCheckBoxActive.isSelected());
                ComboBoxList roleId = (ComboBoxList) this.jComboBoxRole.getSelectedItem();
                Role role = new Role();
                role.setId(roleId.getId());
                this.userAccount.setRole(role);
                try {
                    validatePhoto();
                } catch (URISyntaxException ex) {
                    Logger.getLogger(JDialogUserAU.class.getName()).log(Level.SEVERE, null, ex);
                }
                studentDAOImpl.addUser(userAccount);
                this.dispose();
            }
        } else if (this.title.equals("Update")) {
            int response = JOptionPane.showConfirmDialog(jFrameCafSys, "Are you sure to update " + jTextFieldFirstname.getText() + " " + jTextFieldSurname.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.userAccount.setFirstname(jTextFieldFirstname.getText());
                this.userAccount.setSurname(jTextFieldSurname.getText());
                this.userAccount.setUsername(jTextFieldUsername.getText());
                this.userAccount.setPassword(jTextFieldPassword.getText());
                this.userAccount.setActive(jCheckBoxActive.isSelected());
                ComboBoxList roleId = (ComboBoxList) this.jComboBoxRole.getSelectedItem();
                Role role = new Role();
                role.setId(roleId.getId());
                this.userAccount.setRole(role);
                try {
                    validatePhoto();
                } catch (URISyntaxException ex) {
                    Logger.getLogger(JDialogUserAU.class.getName()).log(Level.SEVERE, null, ex);
                }
                studentDAOImpl.updateUser(userAccount);
                this.dispose();
            }
        } else if (this.title.equals("Delete")) {
            int response = JOptionPane.showConfirmDialog(jFrameCafSys, "Are you sure to delete " + jTextFieldFirstname.getText() + " " + jTextFieldSurname.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                studentDAOImpl.deleteUser(userAccount);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabelPictureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPictureMouseClicked

        browse();
    }//GEN-LAST:event_jLabelPictureMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBoxActive;
    private javax.swing.JComboBox<Object> jComboBoxRole;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelPicture;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextFieldFirstname;
    private javax.swing.JTextField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldSurname;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables

    private void comboBoxUserAccount() {
        roleDAOImpl.comboBoxRole();
        jComboBoxRole.removeAllItems();
        for (ComboBoxList a : roleDAOImpl.getList()) {
            this.jComboBoxRole.addItem(a);
        }
    }

    private File pictureFile = null;

    private void browse() {
        try {
            int returnVal = jFileChooser1.showOpenDialog(this);
            if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
                pictureFile = jFileChooser1.getSelectedFile();
                uploadPhoto(pictureFile);
                int IMG_WIDTH = jLabelPicture.getWidth();
                int IMG_HEIGHT = jLabelPicture.getHeight();

                try {
                    BufferedImage originalImage = ImageIO.read(pictureFile);
                    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                    BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
                    Graphics2D g = resizedImage.createGraphics();
                    g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
                    g.dispose();
                    g.setComposite(AlphaComposite.Src);

                    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g.setRenderingHint(RenderingHints.KEY_RENDERING,
                            RenderingHints.VALUE_RENDER_QUALITY);
                    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

                    jLabelPicture.setIcon(new ImageIcon(resizedImage)); //to eliminate .jpeg from picture filename
                    ImageIO.write(resizedImage, "png", new File(Hrms.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "\\images\\model.jpg"));

                } catch (final IOException ex) {
                    
                }

            } else {
                File defaultDirectory = new File(System.getProperty("user.home"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void uploadPhoto(File file) {
        if (file != null) {
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] imageData = new byte[(int) file.length()];
                fis.read(imageData);
                userAccount.setPhoto(imageData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    int IMG_WIDTH = 200;
    int IMG_HEIGHT = 200;

    private void displayPicture(User userAccount) {
        try {
            byte[] imageData = userAccount.getPhoto();
            ImageIcon imageIcon = new ImageIcon(imageData);

            Image image = imageIcon.getImage();
            int type = BufferedImage.TYPE_INT_ARGB;

            BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(image, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
            g.dispose();
            g.setComposite(AlphaComposite.Src);

            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            jLabelPicture.setIcon(new ImageIcon(resizedImage));//image to label

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validatePhoto() throws URISyntaxException {
        if (userAccount.getPhoto() == null) {
            File targetClassesDir = new File(Hrms.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "\\images\\photo.jpg");
            try {
                FileInputStream fis = new FileInputStream(targetClassesDir);
                byte[] imageData = new byte[(int) targetClassesDir.length()];
                fis.read(imageData);
                userAccount.setPhoto(imageData);
            } catch (Exception e) {
                System.out.println("default of no photo is error");
            }
        }
    }

}
