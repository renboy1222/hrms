/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.hrms.dao;

import com.aldrin.hrms.model.RoomRate;
import java.util.List;

/**
 *
 * @author ALDRIN B. C.
 */
public interface RoomRateDAO {

//    add Role
    public void addRoomRate(RoomRate role);

//    update Role
    public void updateRoomRate(RoomRate role);

//    delete Role
    public void deleteRoomRate(RoomRate role);

//    list of Role
    public List<RoomRate> selectRoomRate();

    public void comboBoxRoomRate();

    public void comboBoxRoomDuration(RoomRate roomId);

    public RoomRate selectDurationToDisplayPriceDownPayment(RoomRate roomRate);

    public String calculateMinutesToCheckOutDuration(RoomRate roomRate, String checkOutDate);
    
    public RoomRate selectRoomInfo(RoomRate roomRate);
    
    public Long getMaxId();
}
