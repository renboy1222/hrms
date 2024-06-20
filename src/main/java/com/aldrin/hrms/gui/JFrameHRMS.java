/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.aldrin.hrms.gui;

import com.aldrin.hrms.Hrms;
import com.aldrin.hrms.dao.impl.UserDAOImpl;
import com.aldrin.hrms.gui.dialog.JDialogChangePassword;
import com.aldrin.hrms.gui.dialog.JDialogCustomer;
import com.aldrin.hrms.gui.dialog.JDialogRoom;
import com.aldrin.hrms.gui.dialog.JDialogRoomRate;
import com.aldrin.hrms.gui.dialog.JDialogRoomStatus;
import com.aldrin.hrms.gui.dialog.JDialogRoomType;
import com.aldrin.hrms.gui.dialog.JDialogStorey;
import com.aldrin.hrms.gui.dialog.JDialogUser;
import com.aldrin.hrms.gui.panel.JPanelReports;
import com.aldrin.hrms.gui.panel.JPanelSales;
import com.aldrin.hrms.gui.panel.JPanelBooking;
import com.aldrin.hrms.gui.panel.JPanelDashboard;
import com.aldrin.hrms.gui.panel.JPanelSettings;
import com.aldrin.hrms.model.User;
import com.aldrin.hrms.util.LoginUser;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.prefs.Preferences;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Java Programming with Aldrin
 */
public class JFrameHRMS extends javax.swing.JFrame {

//    Font fontSize16 = UIManager.getFont("h3.regular.font");
    LoginUser loginUser = new LoginUser();
    private static final String USERNAME_PREF_KEY = "username";
    private static final String PASSWORD_PREF_KEY = "password";
    Preferences preferences = Preferences.userNodeForPackage(Hrms.class);

    private CardLayout cardLayout = new CardLayout();
    private JPanel cardsPanel = new JPanel(cardLayout);
    JPanelBooking panelBooking = new JPanelBooking(this);
    JPanelSales panelSales = new JPanelSales();
    JPanelReports panelReports = new JPanelReports();
    JPanelSettings panelSettings = new JPanelSettings();

    JMenuItem menuItemLogin = new JMenuItem("Login");
    JMenuItem menuItemLogout = new JMenuItem("Logout");
    JMenuItem menuItemChangePassword = new JMenuItem("Change Password");
    JMenuItem menuItemUser = new JMenuItem("User");

    /**
     * Creates new form JFrameApp
     */
    private JFrameHRMS jFrameHRMS;

    public JFrameHRMS() {
        initComponents();
//        Font newFont = fontSize16.deriveFont(16);
//        UIManager.put("defaultFont", newFont);
        FlatLaf.updateUI();
        FlatSVGIcon icon = new FlatSVGIcon("svg/calculator.svg", 24, 24);
        setIconImage(icon.getImage());
        setVisible(true);
        String storedUsername = preferences.get(USERNAME_PREF_KEY, null);
        String storedPassword = preferences.get(PASSWORD_PREF_KEY, null);
        loginUser.setUser(null);

        saveLoginCredentials();

        cardsPanel.add(panelBooking, "Booking");
        cardsPanel.add(panelSales, "Sales");
        cardsPanel.add(panelReports, "Reports");
        cardsPanel.add(panelSettings, "Settings");
        jPanel2.add(cardsPanel, BorderLayout.CENTER);
        this.jFrameHRMS = this;
        popUpMenuSettings();
        popUpMenuUser();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                quitApp();
            }
        });
        toggleIcon();
        clickSideBarButton(jButtonBooking);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanelSideBarButtons = new javax.swing.JPanel();
        jButtonBooking = new javax.swing.JButton();
        jButtonSales = new javax.swing.JButton();
        jButtonReports = new javax.swing.JButton();
        jButtonSettings = new javax.swing.JButton();
        jButtonUser = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton(new FlatSVGIcon("svg/dark.svg",24,24));
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HRMS - Hotel Room Management System");

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(102, 102, 102)));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(140, 10));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(102, 102, 102)));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanelSideBarButtons.setOpaque(false);
        jPanelSideBarButtons.setPreferredSize(new java.awt.Dimension(10, 160));
        jPanelSideBarButtons.setLayout(new java.awt.GridLayout(0, 1));

        jButtonBooking.setIcon(new FlatSVGIcon("svg/book.svg",24,24));
        jButtonBooking.setText("Booking");
        jButtonBooking.setBorder(null);
        jButtonBooking.setBorderPainted(false);
        jButtonBooking.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonBooking.setMargin(new java.awt.Insets(2, 5, 2, 0));
        jButtonBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBookingActionPerformed(evt);
            }
        });
        jPanelSideBarButtons.add(jButtonBooking);

        jButtonSales.setIcon(new FlatSVGIcon("svg/sale.svg",26,26));
        jButtonSales.setText("Sales");
        jButtonSales.setBorder(null);
        jButtonSales.setBorderPainted(false);
        jButtonSales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonSales.setMargin(new java.awt.Insets(2, 5, 2, 0));
        jButtonSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalesActionPerformed(evt);
            }
        });
        jPanelSideBarButtons.add(jButtonSales);

        jButtonReports.setIcon(new FlatSVGIcon("svg/report.svg",24,24));
        jButtonReports.setText("Reports");
        jButtonReports.setBorder(null);
        jButtonReports.setBorderPainted(false);
        jButtonReports.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonReports.setMargin(new java.awt.Insets(2, 5, 2, 0));
        jButtonReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportsActionPerformed(evt);
            }
        });
        jPanelSideBarButtons.add(jButtonReports);

        jButtonSettings.setIcon(new FlatSVGIcon("svg/settings.svg",24,24));
        jButtonSettings.setText("Settings");
        jButtonSettings.setBorder(null);
        jButtonSettings.setBorderPainted(false);
        jButtonSettings.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonSettings.setMargin(new java.awt.Insets(2, 5, 2, 0));
        jButtonSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSettingsActionPerformed(evt);
            }
        });
        jPanelSideBarButtons.add(jButtonSettings);

        jButtonUser.setIcon(new FlatSVGIcon("svg/user.svg",24,24));
        jButtonUser.setText("User");
        jButtonUser.setBorder(null);
        jButtonUser.setBorderPainted(false);
        jButtonUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonUser.setMargin(new java.awt.Insets(2, 5, 2, 0));
        jButtonUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUserActionPerformed(evt);
            }
        });
        jPanelSideBarButtons.add(jButtonUser);

        jPanel4.add(jPanelSideBarButtons, java.awt.BorderLayout.NORTH);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel5.setPreferredSize(new java.awt.Dimension(10, 50));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jToggleButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jToggleButton1.setMaximumSize(new java.awt.Dimension(60, 40));
        jToggleButton1.setMinimumSize(new java.awt.Dimension(60, 40));
        jToggleButton1.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel5.add(jToggleButton1);

        jPanel4.add(jPanel5, java.awt.BorderLayout.SOUTH);

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.WEST);

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(153, 153, 153)));
        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1250, 580));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSettingsActionPerformed
//        cardLayout.show(cardsPanel, "Settings");
    }//GEN-LAST:event_jButtonSettingsActionPerformed

    private void jButtonBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBookingActionPerformed
        cardLayout.show(cardsPanel, "Booking");
         clickSideBarButton(jButtonBooking);
    }//GEN-LAST:event_jButtonBookingActionPerformed

    private void jButtonSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalesActionPerformed
        cardLayout.show(cardsPanel, "Sales");
        clickSideBarButton(jButtonSales);
    }//GEN-LAST:event_jButtonSalesActionPerformed

    private void jButtonReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportsActionPerformed
        cardLayout.show(cardsPanel, "Reports");
        clickSideBarButton(jButtonReports);
    }//GEN-LAST:event_jButtonReportsActionPerformed

    private void jButtonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBooking;
    private javax.swing.JButton jButtonReports;
    private javax.swing.JButton jButtonSales;
    private javax.swing.JButton jButtonSettings;
    private javax.swing.JButton jButtonUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelSideBarButtons;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
private void loginUser() {
        if (loginUser.getUser() != null) {
//            login 
            cardsPanel.setVisible(true);
            cardsPanel.add(panelBooking, "Booking");
            cardsPanel.add(panelSales, "Sales");
            cardsPanel.add(panelReports, "Reports");
            cardsPanel.add(panelSettings, "Settings");
            jPanel2.add(cardsPanel, BorderLayout.CENTER);
            jPanelSideBarButtons.setVisible(true);
            displayPicture(loginUser.getUser());
            if (loginUser.getUser().getRole().getRole().equals("ADMIN")) {
                menuItemUser.setVisible(true);

            } else if (loginUser.getUser().getRole().getRole().equals("USER")) {
                menuItemUser.setVisible(false);
            }
            jPanelSideBarButtons.add(jButtonBooking);
            jPanelSideBarButtons.add(jButtonSales);
            jPanelSideBarButtons.add(jButtonReports);
            jPanelSideBarButtons.add(jButtonSettings);
            jPanelSideBarButtons.add(jButtonUser);
            jButtonBooking.setVisible(true);
            jButtonReports.setVisible(true);
            jButtonSales.setVisible(true);
            jButtonSettings.setVisible(true);
            menuItemLogin.setVisible(false);
            menuItemLogout.setVisible(true);
            menuItemChangePassword.setVisible(true);
            jButtonUser.setText(loginUser.getUser().getFirstname());
        } else {
//            logout
            jPanelSideBarButtons.removeAll();
            jPanelSideBarButtons.setVisible(true);
            jPanelSideBarButtons.add(jButtonUser);
            jPanelSideBarButtons.add(jButtonBooking);
            jPanelSideBarButtons.add(jButtonSales);
            jPanelSideBarButtons.add(jButtonReports);
            jPanelSideBarButtons.add(jButtonSettings);
            jButtonBooking.setVisible(false);
            jButtonReports.setVisible(false);
            jButtonSales.setVisible(false);
            jButtonSettings.setVisible(false);
            menuItemLogin.setVisible(true);
            menuItemLogout.setVisible(false);
            menuItemChangePassword.setVisible(false);
            jButtonUser.setIcon(new FlatSVGIcon("svg/user.svg", 24, 24));
            jButtonUser.setText("User");

        }

    }

    private void clearLoginCredentials() {
        try {
            preferences.remove(USERNAME_PREF_KEY);
            preferences.remove(PASSWORD_PREF_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//

    private void saveLoginCredentials() {
        try {
            UserDAOImpl userDAOImpl = new UserDAOImpl();
            User user = new User();
            String storedUsername = preferences.get(USERNAME_PREF_KEY, null);
            String storedPassword = preferences.get(PASSWORD_PREF_KEY, null);
            user.setUsername(storedUsername);
            user.setPassword(storedPassword);
            if (userDAOImpl.loginUser(user) != null) {
                LoginUser logInUser = new LoginUser();
                user = userDAOImpl.loginUser(user);
                logInUser.setUser(user);
                loginUser();
                displayPicture(logInUser.getUser());

                // login for jdialog
            } else {
                loginUser();
                JDialogLogin logIn = new JDialogLogin(this, true);
                logIn.setVisible(true);
                loginUser();
            }
            addPanels();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addPanels() {
        cardsPanel = new JPanel(cardLayout);
    }

    private void popUpMenuSettings() {
        // Create a popup menu
        JPopupMenu popupMenu = new JPopupMenu();

        // Create and add menu items to the popup menu
        JMenuItem menuItemCustomer = new JMenuItem("Customer");
        menuItemCustomer.setIcon(new FlatSVGIcon("svg/customer.svg", 24, 24));
        JMenuItem menuItemRoom = new JMenuItem("Room");
        menuItemRoom.setIcon(new FlatSVGIcon("svg/room.svg", 24, 24));
        JMenuItem menuItemRoomRate = new JMenuItem("Room rate");
        menuItemRoomRate.setIcon(new FlatSVGIcon("svg/rate.svg", 24, 24));
        JMenuItem menuItemRoomType = new JMenuItem("Room type");
        menuItemRoomType.setIcon(new FlatSVGIcon("svg/type.svg", 24, 24));
        JMenuItem menuItemRoomStatus = new JMenuItem("Room status");
        menuItemRoomStatus.setIcon(new FlatSVGIcon("svg/status.svg", 24, 24));
        JMenuItem menuItemStorey = new JMenuItem("Storey");
        menuItemStorey.setIcon(new FlatSVGIcon("svg/storey.svg", 24, 24));
        menuItemUser.setIcon(new FlatSVGIcon("svg/user.svg", 24, 24));

        popupMenu.add(menuItemCustomer);
        popupMenu.add(menuItemRoom);
        popupMenu.add(menuItemRoomRate);
        popupMenu.add(menuItemRoomType);
        popupMenu.add(menuItemRoomStatus);
        popupMenu.add(menuItemStorey);
        popupMenu.add(menuItemUser);

        // Add action listeners to menu items
        menuItemRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogRoom room = new JDialogRoom(jFrameHRMS, true);
                room.setVisible(true);
            }
        });
        menuItemRoomRate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogRoomRate roomRate = new JDialogRoomRate(jFrameHRMS, true);
                roomRate.setVisible(true);
            }
        });
        menuItemRoomType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogRoomType roomType = new JDialogRoomType(jFrameHRMS, true);
                roomType.setVisible(true);
            }
        });
        menuItemRoomStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogRoomStatus roomStatus = new JDialogRoomStatus(jFrameHRMS, true);
                roomStatus.setVisible(true);
            }
        });

        menuItemCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogCustomer customer = new JDialogCustomer(jFrameHRMS, true);
                customer.setVisible(true);
            }
        });

        menuItemStorey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogStorey storey = new JDialogStorey(jFrameHRMS, true);
                storey.setVisible(true);
            }
        });

        menuItemUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogUser user = new JDialogUser(jFrameHRMS, true);
                user.setVisible(true);
            }
        });

        // Add an action listener to the button to show the popup menu
        jButtonSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the popup menu at the button's location
                popupMenu.show(jButtonSettings, jButtonSettings.getWidth() / 2, jButtonSettings.getHeight() / 2);
            }
        });
    }

    private void popUpMenuUser() {
        JPopupMenu popupMenu = new JPopupMenu();

        // Create and add menu items to the popup menu
        menuItemLogin.setIcon(new FlatSVGIcon("svg/login.svg", 24, 24));

        menuItemLogout.setIcon(new FlatSVGIcon("svg/logout.svg", 24, 24));

        menuItemChangePassword.setIcon(new FlatSVGIcon("svg/key.svg", 24, 24));
        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuItemExit.setIcon(new FlatSVGIcon("svg/close.svg", 24, 24));

        popupMenu.add(menuItemLogin);
        popupMenu.add(menuItemLogout);
        popupMenu.add(menuItemChangePassword);
        popupMenu.add(menuItemExit);

        // Add action listeners to menu items
        menuItemLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanelSideBarButtons.setVisible(false);
                cardsPanel.setVisible(false);
                clearLoginCredentials();
                loginUser.setUser(null);
                jButtonUser.setIcon(null);
                loginUser();
                JDialogLogin login = new JDialogLogin(jFrameHRMS, true);
                login.setVisible(true);
                loginUser();
            }
        });

        menuItemLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogLogin login = new JDialogLogin(jFrameHRMS, true);
                login.setVisible(true);
                loginUser();
            }
        });

        menuItemChangePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogChangePassword cp = new JDialogChangePassword(jFrameHRMS, true);
                cp.setVisible(true);
                cp.dispose();
            }
        });
        menuItemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitApp();
            }
        });

        // Add an action listener to the button to show the popup menu
        jButtonUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the popup menu at the button's location
                popupMenu.show(jButtonUser, jButtonUser.getWidth() / 2, jButtonUser.getHeight() / 2);
            }
        });
    }

    private void quitApp() {
        try {
            int reply = JOptionPane.showConfirmDialog(this,
                    "Are you sure to exit Hotel Room Management application?",
                    "Hotel Room Management - Exit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (reply == JOptionPane.YES_OPTION) {
                System.exit(0);        //Close the Application.
            } else if (reply == JOptionPane.NO_OPTION) {
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    int width = 28;
    int height = 28;

    private void displayPicture(User user) {
        try {
            byte[] imageData = user.getPhoto();
            ImageIcon imageIcon = new ImageIcon(imageData);
            jButtonUser.setIcon(new ImageIcon(getCircleImage(imageIcon.getImage(), width, height)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Image getCircleImage(Image img, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, width, height);
        g2.setClip(circle);
        g2.drawImage(img, 0, 0, width, height, null);
        g2.dispose();
        return image;
    }

    private static boolean isDarkTheme = false;
    private void toggleIcon() {

        // Create the toggle button
        jToggleButton1.setSelectedIcon(new FlatSVGIcon("svg/light.svg", 24, 24));

        // Add an action listener to toggle the icon
        jToggleButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (jToggleButton1.isSelected()) {
//                    jToggleButton1.setIcon(new FlatSVGIcon("svg/dark.svg",24,24));
//                } else {
//                    jToggleButton1.setIcon(new FlatSVGIcon("svg/light.svg",24,24));
//                }
                isDarkTheme = !isDarkTheme;
                setLookAndFeel();
                SwingUtilities.updateComponentTreeUI(jFrameHRMS);
            }
        });
    }
     private static void setLookAndFeel() {
        try {
            if (isDarkTheme) {
                
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } else {
                UIManager.setLookAndFeel(new FlatLightLaf());
            }
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
     
     
     private void clickSideBarButton(JButton button){
         try{
             if(jButtonBooking ==button){
                 jButtonBooking.setBackground(new Color(0, 153, 204));
                 jButtonSales.setBackground(null);
                 jButtonReports.setBackground(null);
                 
                 
             }else if(jButtonSales ==button){
                 jButtonBooking.setBackground(null);
                 jButtonSales.setBackground(new Color(0, 153, 204));
                 jButtonReports.setBackground(null);
                 
             }else if(jButtonReports ==button){
                 jButtonBooking.setBackground(null);
                 jButtonSales.setBackground(null);
                 jButtonReports.setBackground(new Color(0, 153, 204));
                 
             }
             
         }catch(Exception e){
             e.printStackTrace();
         }
     }

}
