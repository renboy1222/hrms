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
public class Room {

    private Long id;
    private String roomNumber;
    private Float price;
    private RoomStatus roomStatus;
    private RoomType roomType;
    private Storey storey;
    private byte[] photo;
    private Date deleted;
}
