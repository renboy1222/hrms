/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms;

/**
 *
 * @author Java Programming with Aldrin
 */
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimePickerDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Date and Time Picker Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Date Chooser
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDate(Calendar.getInstance().getTime());
        frame.add(dateChooser);

        // Time Chooser
        TimeChooser timeChooser = new TimeChooser();
        frame.add(timeChooser);

        // Button to get selected date and time
        JButton button = new JButton("Get Date & Time");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date selectedDate = dateChooser.getDate();
                Calendar selectedTime = timeChooser.getSelectedTime();

                Calendar selectedDateTime = Calendar.getInstance();
                selectedDateTime.setTime(selectedDate);
                selectedDateTime.set(Calendar.HOUR_OF_DAY, selectedTime.get(Calendar.HOUR_OF_DAY));
                selectedDateTime.set(Calendar.MINUTE, selectedTime.get(Calendar.MINUTE));
                selectedDateTime.set(Calendar.SECOND, selectedTime.get(Calendar.SECOND));

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                JOptionPane.showMessageDialog(frame, "Selected Date & Time: " + dateFormat.format(selectedDateTime.getTime()));
            }
        });
        frame.add(button);

        frame.pack();
        frame.setVisible(true);
    }
}

class TimeChooser extends JPanel {
    private JSpinner hourSpinner;
    private JSpinner minuteSpinner;
    private JSpinner secondSpinner;

    public TimeChooser() {
        this.setLayout(new FlowLayout());
        SpinnerNumberModel hourModel = new SpinnerNumberModel(0, 0, 23, 1);
        hourSpinner = new JSpinner(hourModel);
        this.add(hourSpinner);

        SpinnerNumberModel minuteModel = new SpinnerNumberModel(0, 0, 59, 1);
        minuteSpinner = new JSpinner(minuteModel);
        this.add(minuteSpinner);

        SpinnerNumberModel secondModel = new SpinnerNumberModel(0, 0, 59, 1);
        secondSpinner = new JSpinner(secondModel);
        this.add(secondSpinner);
    }

    public Calendar getSelectedTime() {
        Calendar selectedTime = Calendar.getInstance();
        selectedTime.set(Calendar.HOUR_OF_DAY, (int) hourSpinner.getValue());
        selectedTime.set(Calendar.MINUTE, (int) minuteSpinner.getValue());
        selectedTime.set(Calendar.SECOND, (int) secondSpinner.getValue());
        return selectedTime;
    }
}

