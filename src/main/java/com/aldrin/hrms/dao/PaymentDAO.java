/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.hrms.dao;

import com.aldrin.hrms.model.Payment;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALDRIN B. C.
 */
public interface PaymentDAO {

//    add Payment
    public void addPayment(Payment payment);

//    update Payment
    public void updatePayment(Payment payment);

//    delete Payment
    public void deletePayment(Payment payment);

    public Payment selectRoomBookingPayments(Long roomId);

    public void comboBoxInvoiceId();
    
    public ArrayList<Payment> selectUserReceiveAmount(Long userId, Long from,Long to);

}
