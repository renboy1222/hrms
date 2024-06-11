/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms;

/**
 *
 * @author Java Programming with Aldrin
 */
import com.formdev.flatlaf.FlatLightLaf;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CirclePhotoWithRedBorder extends JPanel {

    private BufferedImage image;

    public CirclePhotoWithRedBorder() {
        try {
            // Load your image here
            image = ImageIO.read(new File("C:\\Users\\aldri\\Documents\\NetBeansProjects\\hrms\\src\\main\\resources\\images\\model.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            // Calculate the size of the circle
            int diameter = Math.min(image.getWidth(), image.getHeight());
            int x = (getWidth() - diameter) / 2;
            int y = (getHeight() - diameter) / 2;

            // Create a circular clip
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setClip(new Ellipse2D.Float(x, y, diameter, diameter));
            g2.drawImage(image, x, y, diameter, diameter, this);
            g2.dispose();

            // Draw the red border
            g2 = (Graphics2D) g.create();
            g2.setColor(Color.RED);
            g2.setStroke(new BasicStroke(5)); // Change 5 to your desired border thickness
            g2.draw(new Ellipse2D.Float(x, y, diameter, diameter));
            g2.dispose();
        }
    }

    private static void createAndShowGUI() {
        // Set the FlatLaf look and feel
        FlatLightLaf.install();

        JFrame frame = new JFrame("Circle Photo with Red Border");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new CirclePhotoWithRedBorder());
        frame.setSize(400, 400); // Adjust the frame size as needed
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CirclePhotoWithRedBorder::createAndShowGUI);
    }
}

