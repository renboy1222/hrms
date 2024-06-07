/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.hrms.dao;

import com.aldrin.hrms.model.Bill;
import com.aldrin.hrms.model.Customer;
import java.util.ArrayList;

/**
 *
 * @author ALDRIN B. C.
 */
public interface BillDAO {

//    add Bill
    public void addBill(Bill bill);

//    update Bill
    public void updateBill(Bill bill);

//    delete Bill
    public void deleteBill(Bill bill);

    public Long getMaxId();

}
