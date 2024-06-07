/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms.dao.impl;

import com.aldrin.hrms.dao.BillDAO;
import com.aldrin.hrms.model.Bill;
import com.aldrin.hrms.util.ComboBoxList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ALDRIN B. C.
 */
@Setter
@Getter
public class BillDAOImpl extends DBConnection implements BillDAO {

    @Override
    public void addBill(Bill customer) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
INSERT INTO `bill` (`customer_id`) 
VALUES  (?) ;
                                                                      """);
            ps.setLong(1, customer.getCustomer().getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBill(Bill customer) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
UPDATE 
  `customer` 
SET
  `address` = ?,
  `email` = ?,
  `name` = ?,
  `phone` = ? 
WHERE `customer_id` = ? 
                                                                      """);
            ps.setLong(1, customer.getCustomer().getId());
            ps.setLong(5, customer.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBill(Bill customer) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
                                                                      UPDATE 
                                                                        `customer`
                                                                      SET
                                                                        `deleted` = CURRENT_TIMESTAMP()
                                                                      WHERE `id` = ? ;
                                                                      """);
            ps.setLong(1, customer.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ComboBoxList> list;

    @Override
    public Long getMaxId() {
        Long maxId = null;
        try {
            getDBConn();
            PreparedStatement statement = getCon().prepareStatement("""
                              SELECT 
                                MAX(`id`) AS ID
                                FROM
                              `hrms`.`bill`                                       
                                                                    """);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                if (idl == 0) {
                    maxId = 1L;
                } else {
                    maxId = idl;
                }
            }
            rs.close();
            statement.close();
//            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maxId;
    }

}
