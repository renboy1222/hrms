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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CardLayoutExample extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JPanel panel1;
    private JPanel panel2;
    private Random random;

    public CardLayoutExample() {
        // Initialize the frame
        setTitle("CardLayout Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize CardLayout and main panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        random = new Random();

        // Create panel 1
        panel1 = new JPanel();
        panel1.add(new JLabel("Panel 1"));
        JButton buttonToPanel2 = new JButton("Go to Panel 2");
        panel1.add(buttonToPanel2);
        
        // Create panel 2
        panel2 = new JPanel();
        panel2.add(new JLabel("Panel 2"));
        JButton buttonToPanel1 = new JButton("Go to Panel 1");
        panel2.add(buttonToPanel1);

        // Add action listeners to buttons
        buttonToPanel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePanelBackgroundColor(panel2);
                cardLayout.show(mainPanel, "Panel 2");
            }
        });

        buttonToPanel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePanelBackgroundColor(panel1);
                cardLayout.show(mainPanel, "Panel 1");
            }
        });

        // Add panels to main panel
        mainPanel.add(panel1, "Panel 1");
        mainPanel.add(panel2, "Panel 2");

        // Show the initial panel
        cardLayout.show(mainPanel, "Panel 1");

        // Add main panel to frame
        add(mainPanel);
    }

    private void changePanelBackgroundColor(JPanel panel) {
        // Generate a random color
        Color randomColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        panel.setBackground(randomColor);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CardLayoutExample().setVisible(true);
            }
        });
    }
}

