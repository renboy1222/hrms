/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.hrms.gui;

import com.aldrin.hrms.dao.impl.CustomerDAOImpl;
import com.aldrin.hrms.gui.dialog.au.JDialogCustomerAU;
import com.aldrin.hrms.model.Bill;
import com.aldrin.hrms.model.Booking;
import com.aldrin.hrms.model.Customer;
import com.aldrin.hrms.util.ComboBoxList;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Java Programming with Aldrin
 */
public class JDialogPayment extends javax.swing.JDialog {
    
    private JFrameHRMS jFrameHRMS;
    private DecimalFormat df = new DecimalFormat("##,##0.00");

    /**
     * Creates new form JDialogPayment
     */
    private Float full;
    private Float partial;
    private NumberFormat numberFormat = NumberFormat.getNumberInstance();
    NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
    private JDialogBooking dialogBooking;
    
    public JDialogPayment(JFrameHRMS jFrameHRMS, boolean modal, JDialogBooking addBooking) {
        super(jFrameHRMS, modal);
        this.jFrameHRMS = jFrameHRMS;
        initComponents();
        comboBoxCustomer();
        jLabelFull.setText(String.valueOf(addBooking.getFull()));
        if (addBooking.getPartial() > 0) {
            jLabelPartial.setText(String.valueOf(df.format(addBooking.getPartial())));
        } else {
            jLabelPartial.setText(String.valueOf(df.format(addBooking.getFull())));
        }
        this.dialogBooking = addBooking;
        
        numberFormatter.setValueClass(Long.class); // Specify the value class
//        numberFormatter.setAllowsInvalid(false);   // Only allow valid numbers
        numberFormatter.setMinimum(0L);            // Minimum value
        numberFormatter.setMaximum(Long.MAX_VALUE);// Maximum value
//        jFormattedTextField1.setColumns(20);
        jButtonPayment.setEnabled(false);
        
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
        jLabel2 = new javax.swing.JLabel();
        jComboBoxCustomer = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButtonPayment = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabelPartial = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelFull = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Payment");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("PARTIAL PAYMENT:");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 35));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("TOTAL:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 110, 35));

        getContentPane().add(jComboBoxCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 220, 35));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("+");
        jButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton1.setPreferredSize(new java.awt.Dimension(35, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 43, -1));

        jButtonPayment.setText("Payment");
        jButtonPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPaymentActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 190, 40));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("CUSTOMER:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 35));
        getContentPane().add(jLabelPartial, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 220, 30));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("FULL PAYMENT:");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 35));
        getContentPane().add(jLabelFull, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 220, 30));

        jTextFieldTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldTotalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTotalKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 220, 30));

        setSize(new java.awt.Dimension(444, 316));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPaymentActionPerformed
        Booking booking = new Booking();
        Bill bill = new Bill();
        Customer customer = new Customer();
        dialogBooking.setPay(true);
        ComboBoxList customerId = (ComboBoxList) this.jComboBoxCustomer.getSelectedItem();
        customer.setId(customerId.getId());
        bill.setCustomer(customer);
        booking.setBill(bill);
        booking.setAmount(Float.parseFloat(jTextFieldTotal.getText()));
        dialogBooking.setBooking(booking);
        dialogBooking.setAmountPay(Float.parseFloat(jTextFieldTotal.getText()));
        dispose();
    }//GEN-LAST:event_jButtonPaymentActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JDialogCustomerAU customerAU = new JDialogCustomerAU(jFrameHRMS, true);
        customerAU.setVisible(true);
        comboBoxCustomer();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTotalKeyReleased
        float full = dialogBooking.getFull();
        float partial = dialogBooking.getPartial();
        if (jTextFieldTotal.getText().length() == 0 || jTextFieldTotal.getText().isEmpty()) {
            jButtonPayment.setEnabled(false);
            return;
        }
        float payment = Float.parseFloat(jTextFieldTotal.getText());
        if (full == payment) {
            jButtonPayment.setEnabled(true);
        } else if (partial == payment) {
            jButtonPayment.setEnabled(true);
        } else {
            jButtonPayment.setEnabled(false);
        }
    }//GEN-LAST:event_jTextFieldTotalKeyReleased

    private void jTextFieldTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonPayment;
    private javax.swing.JComboBox<Object> jComboBoxCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelFull;
    private javax.swing.JLabel jLabelPartial;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables
 private CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
    
    private void comboBoxCustomer() {
        customerDAOImpl.comboBoxCustomer();
        jComboBoxCustomer.removeAllItems();
        for (ComboBoxList a : customerDAOImpl.getList()) {
            this.jComboBoxCustomer.addItem(a);
        }
    }

//    //        System.out.println("interger value:" + jFormattedTextField1.getText().replace(",", ""));
//        Float amount = Float.parseFloat(jFormattedTextField1.getText().replace(",", ""));
//        Float full = dialogBooking.getFull();
//        Float partial = dialogBooking.getPartial();
//        if (full == amount) {
//            jButtonPayment.setEnabled(true);
//            System.out.println("if (dialogBooking.getFull() == amount) {" + amount);
//        } else if (partial == amount) {
//            System.out.println("} else if (dialogBooking.getPartial() == amount) {" + amount);
//            jButtonPayment.setEnabled(true);
//        } 
////        else if (full != amount || partial != amount) {
////            jButtonPayment.setEnabled(false);
////            System.out.println("else" + amount);
////        }
//        System.out.println("partial:" + dialogBooking.getPartial());
//        System.out.println("full:" + dialogBooking.getPartial());
//        System.out.println("amount" + amount);
    public static boolean areEqual(float num1, float num2, float epsilon) {
        return Math.abs(num1 - num2) < epsilon;
    }
    
}
