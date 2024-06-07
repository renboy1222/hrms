/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.hrms.dao;

import com.aldrin.hrms.model.RoomStatus;
import java.util.ArrayList;

/**
 *
 * @author ALDRIN B. C.
 */
public interface RoomStatusDAO {

//    add RoomStatus
    public void addRoomStatus(RoomStatus roomStatus);

//    update RoomStatus
    public void updateRoomStatus(RoomStatus roomStatus);

//    delete RoomStatus
    public void deleteRoomStatus(RoomStatus roomStatus);

//    list of RoomStatus 
    public ArrayList<RoomStatus> selectRoomStatus();

    public void comboBoxRoomStatus();

}
