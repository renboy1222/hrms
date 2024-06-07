/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.hrms.dao;

import com.aldrin.hrms.model.Room;
import java.util.ArrayList;

/**
 *
 * @author ALDRIN B. C.
 */
public interface RoomDAO {

//    add Room 
    public void addRoom(Room room);

//    update Room 
    public void updateRoom(Room room);

//    delete Room 
    public void deleteRoom(Room room);

//    list of Room 
    public ArrayList<Room> selectRoom();

    public void comboBoxRoom();

    public Room findPhotoByRoomId(Room room);

}
