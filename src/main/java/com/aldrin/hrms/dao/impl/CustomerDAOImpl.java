/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms.dao.impl;

import com.aldrin.hrms.dao.CustomerDAO;
import com.aldrin.hrms.model.Customer;
import com.aldrin.hrms.util.ComboBoxList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ALDRIN B. C.
 */
@Setter
@Getter
public class CustomerDAOImpl extends DBConnection implements CustomerDAO {

    @Override
    public void addCustomer(Customer customer) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
INSERT INTO `customer` (
  `address`,
  `email`,
  `name`,
  `phone`
) VALUES(?,?,?,?) 
                                                                      """);
            ps.setString(1, customer.getAddress());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getName());
            ps.setString(4, customer.getPhone());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
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
WHERE `id` = ? 
                                                                      """);
            ps.setString(1, customer.getAddress());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getName());
            ps.setString(4, customer.getPhone());
            ps.setLong(5, customer.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(Customer customer) {
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
    public ArrayList<Customer> selectCustomer() {
        ArrayList<Customer> list = new ArrayList<>();
        try {
            String query = """
SELECT 
  `id`,
  `address`,
  `email`,
  `name`,
  `phone` 
FROM
  `customer` WHERE deleted IS NULL ORDER BY `name` ASC;  
                           """;
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getLong("ID"));
                c.setAddress(rs.getString("ADDRESS"));
                c.setEmail(rs.getString("EMAIL"));
                c.setName(rs.getString("NAME"));
                c.setPhone(rs.getString("PHONE"));
                list.add(c);
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void comboBoxCustomer() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("""
                                                SELECT 
                                                    `id`,
                                                    `address`,
                                                    `email`,
                                                    `name`,
                                                    `phone` 
                                                  FROM
                                                    `customer` WHERE deleted IS NULL ORDER BY `name` ASC; 
                                                  """);
            rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                String NAME = rs.getString("NAME");
                this.getList().add(new ComboBoxList(idl, NAME));
            }
            rs.close();
            statement.close();
            closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
