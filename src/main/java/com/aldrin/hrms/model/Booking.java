/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms.model;

import java.util.Date;
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
public class Booking {
//  atttribute

    private Long id;
    private RoomRate roomRate;
    private Date checkInDate;
    private Date checkOutDate;
    private Date reserve;
    private Date createdAt;
    private Float refund;
    private Bill bill;

    // instance variable
    private Float amount;
    private String checkIn;
    private String checkOut;
    private Boolean reserved;
    private Payment payment;

}
