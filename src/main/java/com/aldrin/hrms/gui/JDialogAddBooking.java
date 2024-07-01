/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.hrms.gui;

import com.aldrin.hrms.dao.impl.BookingDAOImpl;
import com.aldrin.hrms.dao.impl.RoomDAOImpl;
import com.aldrin.hrms.dao.impl.RoomRateDAOImpl;
import com.aldrin.hrms.model.Booking;
import com.aldrin.hrms.model.Room;
import com.aldrin.hrms.model.RoomRate;
import com.aldrin.hrms.util.ComboBoxList;
import com.aldrin.hrms.util.CurrentHourAndTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Java Programming with Aldrin
 */
@Setter
@Getter
@ToString
public class JDialogAddBooking extends javax.swing.JDialog {

//    SELECT 
//    '2024-05-15 10:00:00' AS original_timestamp, 
//    DATE_ADD('2024-05-15 10:00:00', INTERVAL 3600 MINUTE) AS new_timestamp;
    /**
     * Creates new form JDialogAddBooking private
     */
    private JFrameHRMS jFrameHrms;
    public AddBooking addBooking = new AddBooking();

    public JDialogAddBooking(JFrameHRMS jFrameHrms, boolean modal) {
        super(jFrameHrms, modal);
        initComponents();
        comboBoxRoom();
        currentHourAndMinute();
//        calculateCheckOutDate();
        calculateDuration();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxRoom = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooserEndDate = new com.toedter.calendar.JDateChooser();
        jDateChooserStartDate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxDuration = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldPrice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldDownPayment = new javax.swing.JTextField();
        jComboBoxEndHour = new javax.swing.JComboBox<>();
        jComboBoxEndMinutes = new javax.swing.JComboBox<>();
        jComboBoxStartHour = new javax.swing.JComboBox<>();
        jComboBoxEndAMPM = new javax.swing.JComboBox<>();
        jComboBoxStartMinutes = new javax.swing.JComboBox<>();
        jComboBoxStartAMPM = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxBooking = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADD BOOKING");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("CHECK-OUT:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 310, 100, 30));

        jComboBoxRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRoomActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 120, 30));

        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 420, 30));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("DURATION:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 150, 100, 30));

        jDateChooserEndDate.setDate(new Date());
        jDateChooserEndDate.setEnabled(false);
        jPanel1.add(jDateChooserEndDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 120, 30));

        jDateChooserStartDate.setDate(new Date());
        jDateChooserStartDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserStartDatePropertyChange(evt);
            }
        });
        jPanel1.add(jDateChooserStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 120, 30));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("DOWNPAYMENT:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 230, 100, 30));

        jComboBoxDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDurationActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxDuration, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 120, 30));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("CHECK-IN:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 270, 100, 30));
        jPanel1.add(jTextFieldPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 120, 30));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("BOOKING:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, 100, 30));

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 120, 40));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("PRICE:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 190, 100, 30));
        jPanel1.add(jTextFieldDownPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 120, 30));

        jComboBoxEndHour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        jComboBoxEndHour.setEnabled(false);
        jPanel1.add(jComboBoxEndHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 310, 50, 30));

        jComboBoxEndMinutes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        jComboBoxEndMinutes.setEnabled(false);
        jPanel1.add(jComboBoxEndMinutes, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 50, 30));

        jComboBoxStartHour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        jComboBoxStartHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxStartHourActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxStartHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 270, 50, 30));

        jComboBoxEndAMPM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        jComboBoxEndAMPM.setEnabled(false);
        jPanel1.add(jComboBoxEndAMPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 310, 60, 30));

        jComboBoxStartMinutes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        jComboBoxStartMinutes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxStartMinutesActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxStartMinutes, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 50, 30));

        jComboBoxStartAMPM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        jComboBoxStartAMPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxStartAMPMActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxStartAMPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 270, 60, 30));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("ROOM:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, 100, 30));

        jComboBoxBooking.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHECK-IN", "RESERVED" }));
        jPanel1.add(jComboBoxBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 120, 30));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(454, 468));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRoomActionPerformed
        try {
            RoomRate rr = new RoomRate();
            ComboBoxList roomIdl = (ComboBoxList) this.jComboBoxRoom.getSelectedItem();
            Room room = new Room();
            room.setId(roomIdl.getId());
            rr.setRoom(room);
            comboBoxRoomDuration(rr);
//
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jComboBoxRoomActionPerformed

    private void jComboBoxDurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDurationActionPerformed

        calculateDuration();

    }//GEN-LAST:event_jComboBoxDurationActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String checkInDate = new java.sql.Date(jDateChooserStartDate.getDate().getTime()).toString();
        String checkOutDate = new java.sql.Date(jDateChooserEndDate.getDate().getTime()).toString();
        Date currentDate = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormatter.format(currentDate);
        if (formattedDate == checkInDate) {
            if (jComboBoxBooking.getSelectedIndex() == 0) {
                JOptionPane.showConfirmDialog(jFrameHrms, "Date you entered is allow only in reserve.", "WARNING!!", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        ComboBoxList roomId = (ComboBoxList) this.jComboBoxRoom.getSelectedItem();
        BookingDAOImpl bookingDAOImpl = new BookingDAOImpl();
//        Booking b = bookingDAOImpl.selectRoomBooking(roomId.getId());
        String checkIn = "";
        String checkOut = "";
        if (jComboBoxStartAMPM.getSelectedIndex() == 0) {
            addBooking.setCheckIn(checkInDate + " " + jComboBoxStartHour.getSelectedItem().toString() + ":" + jComboBoxStartMinutes.getSelectedItem() + ":" + "00");
            checkIn = checkInDate + " " + jComboBoxStartHour.getSelectedItem().toString() + ":" + jComboBoxStartMinutes.getSelectedItem() + ":" + "00";
        } else if (jComboBoxStartAMPM.getSelectedIndex() == 1) {
            addBooking.setCheckIn(checkInDate + " " + (jComboBoxStartHour.getSelectedIndex() + 13) + ":" + jComboBoxStartMinutes.getSelectedItem() + ":" + "00");
            checkIn = checkInDate + " " + (jComboBoxStartHour.getSelectedIndex() + 13) + ":" + jComboBoxStartMinutes.getSelectedItem() + ":" + "00";
        }
        if (jComboBoxEndAMPM.getSelectedIndex() == 0) {
            addBooking.setCheckOut(checkOutDate + " " + jComboBoxEndHour.getSelectedItem().toString() + ":" + jComboBoxEndMinutes.getSelectedItem() + ":" + "00");
            checkOut = checkOutDate + " " + jComboBoxEndHour.getSelectedItem().toString() + ":" + jComboBoxEndMinutes.getSelectedItem() + ":" + "00";
        } else if (jComboBoxEndAMPM.getSelectedIndex() == 1) {
            addBooking.setCheckOut(checkOutDate + " " + (jComboBoxEndHour.getSelectedIndex() + 13) + ":" + jComboBoxEndMinutes.getSelectedItem() + ":" + "00");
            checkOut = checkOutDate + " " + (jComboBoxEndHour.getSelectedIndex() + 13) + ":" + jComboBoxEndMinutes.getSelectedItem() + ":" + "00";
        }
        Booking b = bookingDAOImpl.selectRoomBookingByRoomIdAndCheckOutAndCheckIn(roomId.getId(), checkIn, checkOut);
        if (b.getCheckOut() != null) {
            JOptionPane.showMessageDialog(jFrameHrms, "Room " + jComboBoxRoom.getSelectedItem().toString() + " is occufied in this time", "WARNING!!", JOptionPane.PLAIN_MESSAGE);
            return;
        } else {

            RoomRate rt = new RoomRate();
            ComboBoxList durationId = (ComboBoxList) this.jComboBoxDuration.getSelectedItem();
            rt.setId(durationId.getId());
            addBooking.setRoomRate(rt);
            addBooking.setRoom(jComboBoxRoom.getSelectedItem().toString());
            addBooking.setPrice(Float.parseFloat(jTextFieldPrice.getText()));
            addBooking.setDownPayment(Float.parseFloat(jTextFieldDownPayment.getText()));
            addBooking.setDuration(jComboBoxDuration.getSelectedItem().toString());
            if (jComboBoxStartAMPM.getSelectedIndex() == 0) {
                addBooking.setCheckIn(checkInDate + " " + jComboBoxStartHour.getSelectedItem().toString() + ":" + jComboBoxStartMinutes.getSelectedItem() + ":" + "00");
            } else if (jComboBoxStartAMPM.getSelectedIndex() == 1) {
                addBooking.setCheckIn(checkInDate + " " + (jComboBoxStartHour.getSelectedIndex() + 13) + ":" + jComboBoxStartMinutes.getSelectedItem() + ":" + "00");
            }
            if (jComboBoxEndAMPM.getSelectedIndex() == 0) {
                addBooking.setCheckOut(checkOutDate + " " + jComboBoxEndHour.getSelectedItem().toString() + ":" + jComboBoxEndMinutes.getSelectedItem() + ":" + "00");
            } else if (jComboBoxEndAMPM.getSelectedIndex() == 1) {
                addBooking.setCheckOut(checkOutDate + " " + (jComboBoxEndHour.getSelectedIndex() + 13) + ":" + jComboBoxEndMinutes.getSelectedItem() + ":" + "00");
            }
            if (jComboBoxBooking.getSelectedIndex() == 0) {
                addBooking.setReserve(false);
            } else {
                addBooking.setReserve(true);
            }

            AddBooking addBooking = new AddBooking();
            addBooking.setAddBooking(this.addBooking);
            dispose();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxStartAMPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStartAMPMActionPerformed
        calculateHour();
        calculateCheckOutDate();
    }//GEN-LAST:event_jComboBoxStartAMPMActionPerformed

    private void jComboBoxStartHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStartHourActionPerformed
//        calculateHour();
        calculateCheckOutDate();
    }//GEN-LAST:event_jComboBoxStartHourActionPerformed

    private void jDateChooserStartDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserStartDatePropertyChange
        try {
            RoomRate rr = new RoomRate();
            ComboBoxList durationId = (ComboBoxList) this.jComboBoxDuration.getSelectedItem();
            rr.setId(durationId.getId());
            rr = roomRateDAOImpl.selectDurationToDisplayPriceDownPayment(rr);
            jTextFieldPrice.setText(String.valueOf(rr.getPrice()));
            jTextFieldDownPayment.setText(String.valueOf(rr.getDown_payment()));
            String checkInDate = new java.sql.Date(jDateChooserStartDate.getDate().getTime()).toString();
            String cDate = checkInDate + " " + jComboBoxStartHour.getSelectedItem().toString() + ":" + jComboBoxStartMinutes.getSelectedItem() + ":" + "00";
            ComboBoxList rrIdl = (ComboBoxList) this.jComboBoxDuration.getSelectedItem();
            rr.setId(rrIdl.getId());
            String checkOut = roomRateDAOImpl.calculateMinutesToCheckOutDuration(rr, cDate);
            jDateChooserEndDate.setDate(new Date(Integer.parseInt(checkOut.toString().substring(0, 4)) - 1900, Integer.parseInt(checkOut.toString().substring(5, 7)) - 1, Integer.parseInt(checkOut.substring(8, 10))));
            int hour = Integer.parseInt(checkOut.toString().substring(11, 13));
            if (hour > 12) {
                //PM
                jComboBoxEndHour.setSelectedIndex(Integer.parseInt(checkOut.toString().substring(11, 13)) - 12);
            } else if (hour < 12) {
                jComboBoxEndHour.setSelectedIndex(Integer.parseInt(checkOut.toString().substring(11, 13)) - 1);
            } else if (hour == 24) {
                jComboBoxEndHour.setSelectedIndex(Integer.parseInt(checkOut.toString().substring(11, 13)) - 12);
            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_jDateChooserStartDatePropertyChange

    private void jComboBoxStartMinutesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStartMinutesActionPerformed
        calculateCheckOutDate();
    }//GEN-LAST:event_jComboBoxStartMinutesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxBooking;
    private javax.swing.JComboBox<Object> jComboBoxDuration;
    private javax.swing.JComboBox<String> jComboBoxEndAMPM;
    private javax.swing.JComboBox<String> jComboBoxEndHour;
    private javax.swing.JComboBox<String> jComboBoxEndMinutes;
    private javax.swing.JComboBox<Object> jComboBoxRoom;
    private javax.swing.JComboBox<String> jComboBoxStartAMPM;
    private javax.swing.JComboBox<String> jComboBoxStartHour;
    private javax.swing.JComboBox<String> jComboBoxStartMinutes;
    private com.toedter.calendar.JDateChooser jDateChooserEndDate;
    private com.toedter.calendar.JDateChooser jDateChooserStartDate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldDownPayment;
    private javax.swing.JTextField jTextFieldPrice;
    // End of variables declaration//GEN-END:variables
//     public static void main(String[] args) {
//        JDialogAddBooking add = new JDialogAddBooking(null, true);
//        add.setVisible(true);
//    }

    private RoomDAOImpl roomDAOImpl = new RoomDAOImpl();
    private RoomRateDAOImpl roomRateDAOImpl = new RoomRateDAOImpl();

    private void comboBoxRoom() {
        roomDAOImpl.comboBoxRoom();
        jComboBoxRoom.removeAllItems();
        for (ComboBoxList a : roomDAOImpl.getList()) {
            this.jComboBoxRoom.addItem(a);
        }
    }

    private void comboBoxRoomDuration(RoomRate roomId) {
        roomRateDAOImpl.comboBoxRoomDuration(roomId);
        jComboBoxDuration.removeAllItems();
        for (ComboBoxList a : roomRateDAOImpl.getList()) {
            this.jComboBoxDuration.addItem(a);
        }
    }

    private void calculateHour() {
        String hour = "";
        String min = jComboBoxStartMinutes.getSelectedItem().toString();
        String date = new java.sql.Date(jDateChooserStartDate.getDate().getTime()).toString();

        if (jComboBoxStartAMPM.getSelectedIndex() == 1) {
            int selected = jComboBoxStartHour.getSelectedIndex();
            int hh = selected + 13;
            hour = String.valueOf(hh);
        } else {
            int selected = jComboBoxStartHour.getSelectedIndex();
            int hh = selected + 1;
            hour = String.valueOf("0" + hh);
        }
        //start
        CurrentHourAndTime ct = new CurrentHourAndTime();
        int hh = Integer.parseInt(ct.selectHourAndMinutes().getCurrentTime().substring(0, 2));
        int mm = Integer.parseInt(ct.selectHourAndMinutes().getCurrentTime().substring(3, 5));
        if (jComboBoxStartAMPM.getSelectedIndex() == 0) {

        }

        String timeStamp = date + ":" + hour + ":" + min + ":00";
        jDateChooserEndDate.setDate(new Date(Integer.parseInt(date.toString().substring(0, 4)) - 1900, Integer.parseInt(date.toString().substring(5, 7)) - 1, Integer.parseInt(date.toString().substring(8))));

    }

    private void currentHourAndMinute() {
        CurrentHourAndTime ct = new CurrentHourAndTime();
        int hh = Integer.parseInt(ct.selectHourAndMinutes().getCurrentTime().substring(0, 2));
        int mm = Integer.parseInt(ct.selectHourAndMinutes().getCurrentTime().substring(3, 5));
        if (hh < 12) {
            //AM
            jComboBoxStartHour.setSelectedIndex(hh - 1);
            jComboBoxStartMinutes.setSelectedIndex(mm);
            jComboBoxStartAMPM.setSelectedIndex(0);
            jComboBoxEndHour.setSelectedIndex(hh);
            jComboBoxEndMinutes.setSelectedIndex(mm);
            jComboBoxEndAMPM.setSelectedIndex(0);
        } else if (hh == 12) {
            //AM
            jComboBoxStartHour.setSelectedIndex(hh - 1);
            jComboBoxStartMinutes.setSelectedIndex(mm);
            jComboBoxStartAMPM.setSelectedIndex(0);
            jComboBoxEndHour.setSelectedIndex(hh - 1);
            jComboBoxEndMinutes.setSelectedIndex(mm);
            jComboBoxEndAMPM.setSelectedIndex(0);

        } else if (hh > 12) {
            //AM
            jComboBoxStartHour.setSelectedIndex(hh - 13);
            jComboBoxStartMinutes.setSelectedIndex(mm);
            jComboBoxStartAMPM.setSelectedIndex(1);
            jComboBoxEndHour.setSelectedIndex(hh - 13);
            jComboBoxEndMinutes.setSelectedIndex(mm);
            if ((hh + jComboBoxEndHour.getSelectedIndex()) > 24) {
                jComboBoxEndAMPM.setSelectedIndex(1);
            } else if ((hh + jComboBoxEndHour.getSelectedIndex()) < 24) {
                jComboBoxEndAMPM.setSelectedIndex(1);
            } else if ((hh + jComboBoxEndHour.getSelectedIndex()) == 24) {
                jComboBoxEndAMPM.setSelectedIndex(0);
            } else {
                jComboBoxEndAMPM.setSelectedIndex(1);
            }

        } else {
            //PM
            jComboBoxStartHour.setSelectedIndex(hh - 13);
            jComboBoxStartMinutes.setSelectedIndex(mm);
            jComboBoxStartAMPM.setSelectedIndex(1);
            jComboBoxEndHour.setSelectedIndex(hh - 13);
            jComboBoxEndMinutes.setSelectedIndex(mm);
            jComboBoxEndAMPM.setSelectedIndex(1);
        }
    }

    private void calculateCheckOutDate() {
        String checkInDate = new java.sql.Date(jDateChooserStartDate.getDate().getTime()).toString();
        CurrentHourAndTime ct = new CurrentHourAndTime();
        int hh = Integer.parseInt(ct.selectHourAndMinutes().getCurrentTime().substring(0, 2));
        int mm = Integer.parseInt(ct.selectHourAndMinutes().getCurrentTime().substring(3, 5));
        String cDate = checkInDate + " " + jComboBoxStartHour.getSelectedItem().toString() + ":" + jComboBoxStartMinutes.getSelectedItem().toString() + ":" + "00";
        RoomRate rr = new RoomRate();
        if (jComboBoxDuration.getItemCount() == 0) {

            return;
        } else {
            ComboBoxList rrIdl = (ComboBoxList) this.jComboBoxDuration.getSelectedItem();
            rr.setId(rrIdl.getId());
        }

        String checkOut = roomRateDAOImpl.calculateMinutesToCheckOutDuration(rr, cDate);
        jDateChooserEndDate.setDate(new Date(Integer.parseInt(checkOut.toString().substring(0, 4)) - 1900, Integer.parseInt(checkOut.toString().substring(5, 7)) - 1, Integer.parseInt(checkOut.substring(8, 10))));
        int hour = Integer.parseInt(checkOut.toString().substring(11, 13));
        int minutes = Integer.parseInt(checkOut.toString().substring(14, 16));
        if (hour > 12) {
            //PM
            jComboBoxEndHour.setSelectedIndex(Integer.parseInt(checkOut.toString().substring(11, 13)) - 13);
            jComboBoxEndMinutes.setSelectedIndex(minutes);
            jComboBoxEndAMPM.setSelectedIndex(1);

        } else if (hour < 12) {
            jComboBoxEndHour.setSelectedIndex(Integer.parseInt(checkOut.toString().substring(11, 13)) - 1);
            jComboBoxEndMinutes.setSelectedIndex(minutes);
            jComboBoxEndAMPM.setSelectedIndex(0);
        } else if (hour == 24) {
            jComboBoxEndHour.setSelectedIndex(Integer.parseInt(checkOut.toString().substring(11, 13)) - 12);
            jComboBoxEndMinutes.setSelectedIndex(minutes);
        }
        int n = Integer.parseInt(checkOut.toString().substring(11, 13));

    }

    private void calculateDuration() {
        try {
            RoomRate rr = new RoomRate();
            ComboBoxList durationId = (ComboBoxList) this.jComboBoxDuration.getSelectedItem();
            rr.setId(durationId.getId());
            rr = roomRateDAOImpl.selectDurationToDisplayPriceDownPayment(rr);
            jTextFieldPrice.setText(String.valueOf(rr.getPrice()));
            jTextFieldDownPayment.setText(String.valueOf(rr.getDown_payment()));
            String checkInDate = new java.sql.Date(jDateChooserStartDate.getDate().getTime()).toString();
            String cDate = checkInDate + " " + jComboBoxStartHour.getSelectedItem().toString() + ":" + jComboBoxStartMinutes.getSelectedItem() + ":" + "00";
            ComboBoxList rrIdl = (ComboBoxList) this.jComboBoxDuration.getSelectedItem();
            rr.setId(rrIdl.getId());
            String checkOut = roomRateDAOImpl.calculateMinutesToCheckOutDuration(rr, cDate);
            jDateChooserEndDate.setDate(new Date(Integer.parseInt(checkOut.toString().substring(0, 4)) - 1900, Integer.parseInt(checkOut.toString().substring(5, 7)) - 1, Integer.parseInt(checkOut.substring(8, 10))));
            int hour = Integer.parseInt(checkOut.toString().substring(11, 13));
            if (jComboBoxStartAMPM.getSelectedIndex() == 0) {

            }
        } catch (Exception e) {
        }
    }

//    public static void main(String[] args) {
//        JDialogAddBooking a = new JDialogAddBooking(null, true);
//        a.setVisible(true);
//    }

}
