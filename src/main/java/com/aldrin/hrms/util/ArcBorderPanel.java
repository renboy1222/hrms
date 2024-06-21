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
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class ArcBorderPanel extends JPanel {

    public ArcBorderPanel() {
        super();
        setPreferredSize(new Dimension(300, 200));
//        setBackground(Color.LIGHT_GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Cast Graphics to Graphics2D for more advanced control
        Graphics2D g2 = (Graphics2D) g;

        // Enable antialiasing for smoother graphics
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define the arc border dimensions and arc width/height
        int arcWidth = 30;
        int arcHeight = 30;
        int borderWidth = 5;

        // Define the shape with round corners (an arc border)
        Shape border = new RoundRectangle2D.Double(borderWidth / 2.0, borderWidth / 2.0,
                getWidth() - borderWidth, getHeight() - borderWidth,
                arcWidth, arcHeight);

        // Set the border color and draw it
        g2.setColor(new Color(0, 102, 204));
        g2.setStroke(new BasicStroke(borderWidth));
        g2.draw(border);
    }

}
