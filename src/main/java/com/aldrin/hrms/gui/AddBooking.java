/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms.gui;

import com.aldrin.hrms.model.RoomRate;
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
public class AddBooking {
//    "ROOM RATE ID", "ROOM", "TYPE","CAPACITY", "PRICE", "DOWN PAYMENT","DURATION","CHECK-IN","CHECK-OUT","RESERVE"
    private static AddBooking addBooking;
    private RoomRate roomRate;
    private String room;
    private String type;
    private Float price;
    private Float downPayment;
    private String duration;
    private String checkIn;
    private String checkOut;
    private Boolean reserve;
    

    /**
     * @return the addBooking
     */
    public static AddBooking getAddBooking() {
        return addBooking;
    }

    /**
     * @param aAddBooking the addBooking to set
     */
    public void setAddBooking(AddBooking aAddBooking) {
        addBooking = aAddBooking;
    }
    
    
}
