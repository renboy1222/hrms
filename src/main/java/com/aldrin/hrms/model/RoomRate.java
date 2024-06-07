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
public class RoomRate {

    private Long id;
    private Room room;   
    private Float price;
    private Duration duration;
    private Float down_payment;
    private Float refundable;
    private Date deleted;
    
    
}
