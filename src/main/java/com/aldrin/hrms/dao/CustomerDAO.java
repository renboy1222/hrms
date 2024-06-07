/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.hrms.dao;

import com.aldrin.hrms.model.Customer;
import java.util.ArrayList;

/**
 *
 * @author ALDRIN B. C.
 */
public interface CustomerDAO {

//    add Customer
    public void addCustomer(Customer customer);

//    update Customer
    public void updateCustomer(Customer customer);

//    delete Customer
    public void deleteCustomer(Customer customer);

//    list of Customer 
    public ArrayList<Customer> selectCustomer();

    public void comboBoxCustomer();

}
