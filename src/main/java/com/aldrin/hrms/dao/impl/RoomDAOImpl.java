/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms.dao.impl;

import com.aldrin.hrms.dao.RoomDAO;
import com.aldrin.hrms.model.Room;
import com.aldrin.hrms.model.RoomStatus;
import com.aldrin.hrms.model.RoomType;
import com.aldrin.hrms.model.Storey;
import com.aldrin.hrms.util.ComboBoxList;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ALDRIN B. C.
 */
@Setter
@Getter
public class RoomDAOImpl extends DBConnection implements RoomDAO {

    @Override
    public void addRoom(Room room) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
INSERT INTO `room` (
  `photo`,
  `price`,
  `room_number`,
  `status_id`,
  `type_id`,`storey_id` 
) VALUES(?,?,?,?,?,?) ;
                                                                      """);
            ps.setBytes(1, room.getPhoto());
            ps.setFloat(2, room.getPrice());
            ps.setString(3, room.getRoomNumber());
            ps.setLong(4, room.getRoomStatus().getId());
            ps.setLong(5, room.getRoomType().getId());
            ps.setLong(6, room.getStorey().getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRoom(Room room) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
UPDATE 
  `room` 
SET 
  `photo` = ?,
  `price` = ?,
  `room_number` = ?,
  `status_id` = ?,
  `type_id` = ? , `storey_id` = ? 
WHERE `id` = ?;
                                                                      """);
            ps.setBytes(1, room.getPhoto());
            ps.setFloat(2, room.getPrice());
            ps.setString(3, room.getRoomNumber());
            ps.setLong(4, room.getRoomStatus().getId());
            ps.setLong(5, room.getRoomType().getId());
            ps.setLong(6, room.getStorey().getId());
            ps.setLong(7, room.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRoom(Room room) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
                                                                      UPDATE 
                                                                        `room`
                                                                      SET
                                                                        `deleted` = CURRENT_TIMESTAMP()
                                                                      WHERE `id` = ? ;
                                                                      """);
            ps.setLong(1, room.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ComboBoxList> list;

    @Override
    public ArrayList<Room> selectRoom() {
        ArrayList<Room> list = new ArrayList<>();
        try {
            String query = """
SELECT
     `room`.`id`
     , `room`.`status_id`
     , `room`.`type_id`
     , `room`.`storey_id`
     , `room`.`room_number`
     , `room`.`price`
     , `room_status`.`status`
     , `room_type`.`type`
     , `room_type`.`capacity`
     , `room_storey`.`storey`
 FROM
     `room`
     INNER JOIN `room_type` 
         ON (`room`.`type_id` = `room_type`.`id`)
     INNER JOIN `room_status` 
         ON (`room`.`status_id` = `room_status`.`id`)
     INNER JOIN `room_storey` 
         ON (`room`.`storey_id` = `room_storey`.`id`) WHERE `room`.`deleted` IS NULL ORDER BY `room`.`room_number` ASC 
                           """;
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Room room = new Room();
                RoomStatus roomStatus = new RoomStatus();
                RoomType roomType = new RoomType();
                Storey storey = new Storey();
                room.setId(rs.getLong("ID"));
                room.setRoomNumber(rs.getString("ROOM_NUMBER"));
                room.setPrice(rs.getFloat("PRICE"));
                roomStatus.setId(rs.getLong("STATUS_ID"));
                roomStatus.setStatus(rs.getString("STATUS"));
                roomType.setId(rs.getLong("TYPE_ID"));
                roomType.setType(rs.getString("TYPE"));
                roomType.setCapacity(rs.getInt("CAPACITY"));
                storey.setId(rs.getLong("STOREY_ID"));
                storey.setStorey(rs.getString("STOREY"));
                room.setStorey(storey);
                room.setRoomStatus(roomStatus);
                room.setRoomType(roomType);
                list.add(room);
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void comboBoxRoom() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("""
                                                SELECT 
                                                    `id`,
                                                    `room_number`  
                                                  FROM
                                                    `room` WHERE deleted IS NULL ORDER BY `room_number` ASC; 
                                                  """);
            rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                String NAME = rs.getString("ROOM_NUMBER");
                this.getList().add(new ComboBoxList(idl, NAME));
            }
            rs.close();
            statement.close();
            closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Room findPhotoByRoomId(Room room) {
        Room userPhoto = new Room();
        Blob photo = null;
        try {
            getDBConn();
            PreparedStatement statement = getCon().prepareStatement("SELECT  PHOTO FROM ROOM  WHERE ID  =" + room.getId() + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Blob picturel = rs.getBlob("PHOTO");
                photo = picturel;
                byte[] bytes = convertBlobToBytes(picturel);
                userPhoto.setPhoto(bytes);
            }
            rs.close();
            statement.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return userPhoto;
    }

    private static byte[] convertBlobToBytes(java.sql.Blob blob) throws IOException, SQLException {
        try (InputStream inputStream = blob.getBinaryStream()) {
            return convertInputStreamToBytes(inputStream);
        }
    }

    private static byte[] convertInputStreamToBytes(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        return outputStream.toByteArray();
    }

    private static void writeBytesToFile(byte[] bytes, String filePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(bytes);
        }
    }

}
