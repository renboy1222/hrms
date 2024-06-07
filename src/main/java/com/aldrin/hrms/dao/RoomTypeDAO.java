/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.hrms.dao;

import com.aldrin.hrms.model.RoomType;
import java.util.ArrayList;

/**
 *
 * @author ALDRIN B. C.
 */
public interface RoomTypeDAO {

//    add RoomType 
    public void addRoomType(RoomType roomType);

//    update RoomType 
    public void updateRoomType(RoomType roomType);

//    delete RoomType 
    public void deleteRoomType(RoomType roomType);

//    list of RoomType 
    public ArrayList<RoomType> selectRoomType();

    public void comboBoxRoomType();

}
