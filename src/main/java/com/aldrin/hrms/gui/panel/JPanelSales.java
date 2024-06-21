/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.aldrin.hrms.gui.panel;

import com.aldrin.hrms.dao.impl.PaymentDAOImpl;
import com.aldrin.hrms.dao.impl.UserDAOImpl;
import com.aldrin.hrms.gui.JFrameHRMS;
import com.aldrin.hrms.model.Payment;
import com.aldrin.hrms.util.ComboBoxList;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Java Programming with Aldrin
 */
public class JPanelSales extends javax.swing.JPanel {

    private JFrameHRMS jFrameHRMS;
    private static Long userId;
    private static Long fromId;
    private static Long toId;

    public JPanelSales() {
        initComponents();
        setTable();
        comboBoxUser();
        comboBoxFromInvoice();
        comboBoxToInvoice();
        jTextFieldSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search");
        calculateTotal();
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
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSales = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxUser = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxFrom = new javax.swing.JComboBox<>();
        jComboBoxTo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

        jTableSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableSales);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel8.setPreferredSize(new java.awt.Dimension(811, 10));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel8, java.awt.BorderLayout.NORTH);

        jPanel5.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel6.setPreferredSize(new java.awt.Dimension(915, 40));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel11.setPreferredSize(new java.awt.Dimension(250, 280));
        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 15, 5));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Total:");
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel11.add(jLabel5);

        jLabelTotal.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotal.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel11.add(jLabelTotal);

        jPanel6.add(jPanel11, java.awt.BorderLayout.EAST);

        jPanel5.add(jPanel6, java.awt.BorderLayout.SOUTH);

        jPanel9.setPreferredSize(new java.awt.Dimension(10, 396));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel9, java.awt.BorderLayout.WEST);

        jPanel7.setPreferredSize(new java.awt.Dimension(10, 396));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7, java.awt.BorderLayout.EAST);

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(1000, 80));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("User:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 2, 37, 26));

        jComboBoxUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUserActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBoxUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 2, 242, 26));

        jLabel2.setText("From Invoice ID:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 2, -1, 26));

        jLabel3.setText("To Invoice ID:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 2, -1, 26));

        jComboBoxFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFromActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBoxFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 2, 260, 26));

        jComboBoxTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxToActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBoxTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 2, 240, 26));

        jLabel4.setText("Search:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 48, 26));
        jPanel3.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 950, 30));

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel10.setPreferredSize(new java.awt.Dimension(940, 40));
        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        jLabel6.setText("Sales");
        jPanel10.add(jLabel6);

        add(jPanel10, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUserActionPerformed
        //        selectPaymentReceived();
        ComboBoxList toId = (ComboBoxList) this.jComboBoxUser.getSelectedItem();
        setUserId(toId.getId());
        selectPaymentReceived();
    }//GEN-LAST:event_jComboBoxUserActionPerformed

    private void jComboBoxFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFromActionPerformed

        ComboBoxList toId = (ComboBoxList) this.jComboBoxFrom.getSelectedItem();
        setFromId(toId.getId());
        selectPaymentReceived();
    }//GEN-LAST:event_jComboBoxFromActionPerformed

    private void jComboBoxToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxToActionPerformed
        ComboBoxList toId = (ComboBoxList) this.jComboBoxTo.getSelectedItem();
        setToId(toId.getId());
        selectPaymentReceived();
    }//GEN-LAST:event_jComboBoxToActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> jComboBoxFrom;
    private javax.swing.JComboBox<Object> jComboBoxTo;
    private javax.swing.JComboBox<Object> jComboBoxUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSales;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables

    private UserDAOImpl userDAOImpl = new UserDAOImpl();
    private PaymentDAOImpl paymentDAOImpl = new PaymentDAOImpl();

    public void comboBoxUser() {
        userDAOImpl.comboBoxUser();
        jComboBoxUser.removeAllItems();
        for (ComboBoxList a : userDAOImpl.getList()) {
            this.jComboBoxUser.addItem(a);
        }
    }

    public void comboBoxFromInvoice() {
        paymentDAOImpl.comboBoxInvoiceId();
        jComboBoxFrom.removeAllItems();
        for (ComboBoxList a : paymentDAOImpl.getList()) {
            this.jComboBoxFrom.addItem(a);
        }
    }

    public void comboBoxToInvoice() {
        paymentDAOImpl.comboBoxInvoiceId();
        jComboBoxTo.removeAllItems();
        for (ComboBoxList a : paymentDAOImpl.getList()) {
            this.jComboBoxTo.addItem(a);
        }
    }

    DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"INVOICE ID", "CREATED", "CUSTOMER", "AMOUNT", "AMOUNT UF"}, 0) {
        public Class getColumnClass(int columnIndex) {
            if (columnIndex == 0) {
                return String.class;
            }
            switch (columnIndex) {
                case 1:
                    return String.class;
                case 2:
                    return String.class;
                case 3:
                    return Integer.class;
                case 4:
                    return String.class;
                default:
                    return String.class;
            }
        }
    };

    private TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);

    private void setTable() {
        jTableSales.setCellSelectionEnabled(true);
        jTableSales = new JTable(tableModel);
        jScrollPane1.setViewportView(jTableSales);
//        jTableCategory.addMouseListener(this);
        jTableSales.setRowSorter(sorter);
        TableColumn hide0 = jTableSales.getColumnModel().getColumn(4);
        hide0.setMinWidth(0);
        hide0.setMaxWidth(0);
        hide0.setPreferredWidth(0);
        JTableHeader header = jTableSales.getTableHeader();
        header.setFont(new Font("Courier New", Font.PLAIN, 14));
        header.setBackground(new java.awt.Color(70, 130, 180));

        TableColumn[] column = new TableColumn[100];
        column[1] = jTableSales.getColumnModel().getColumn(1);
        column[1].setPreferredWidth(110);

    }

    private ArrayList<Payment> paymentList;
    private DecimalFormat df = new DecimalFormat("##,##0.00");

    public void selectPaymentReceived() {
        tableModel.setRowCount(0);
        paymentList = paymentDAOImpl.selectUserReceiveAmount(getUserId(), getFromId(), getToId());
        tableModel.setRowCount(0);
        for (Payment p : paymentList) {
            tableModel.addRow(new Object[]{p.getId(), p.getCreatedAtF(), p.getBill().getCustomer().getName(), df.format(p.getAmount()), p.getAmount()});
        }
        calculateTotal();

    }

    /**
     * @return the userId
     */
    public static Long getUserId() {
        return userId;
    }

    /**
     * @param aUserId the userId to set
     */
    public static void setUserId(Long aUserId) {
        userId = aUserId;
    }

    /**
     * @return the fromId
     */
    public static Long getFromId() {
        return fromId;
    }

    /**
     * @param aFromId the fromId to set
     */
    public static void setFromId(Long aFromId) {
        fromId = aFromId;
    }

    /**
     * @return the toId
     */
    public static Long getToId() {
        return toId;
    }

    /**
     * @param aToId the toId to set
     */
    public static void setToId(Long aToId) {
        toId = aToId;
    }

    private void calculateTotal() {
        float total = 0.0f;
        for (int i = 0; i < jTableSales.getRowCount(); i++) {
            float amount = (float) jTableSales.getValueAt(i, 4);
            total = total + amount;
        }
        jLabelTotal.setText(String.valueOf(df.format(total)));
    }

}
