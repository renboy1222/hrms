/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.hrms.dao;

import com.aldrin.hrms.model.Booking;

/**
 *
 * @author ALDRIN B. C.
 */
public interface BookingDAO {

//    add Booking
    public void addBooking(Booking booking);

    public void addBookingReserve(Booking booking);

//    update Booking
    public void updateBooking(Booking booking);

//    delete Booking
    public void deleteBooking(Booking booking);

    public Long getMaxId();

    public Booking selectRoomBookingByRoomId(Long roomId);
    
    public Booking selectRoomBookingByRoomIdAndCheckOutAndCheckIn(Long roomId,String checkIn,String checkOut);

}
