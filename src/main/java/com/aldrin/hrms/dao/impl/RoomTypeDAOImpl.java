/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms.dao.impl;

import com.aldrin.hrms.dao.RoomTypeDAO;
import com.aldrin.hrms.model.RoomType;
import com.aldrin.hrms.util.ComboBoxList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ALDRIN B. C.
 */
@Setter
@Getter
public class RoomTypeDAOImpl extends DBConnection implements RoomTypeDAO {

    @Override
    public void addRoomType(RoomType roomType) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
                                                                      INSERT INTO `room_type` (
                                                                        `capacity`,
                                                                        `description`,
                                                                        `type`
                                                                      ) 
                                                                      VALUES
                                                                        (?,?,?) ;
                                                                      """);
            ps.setInt(1, roomType.getCapacity());
            ps.setString(2, roomType.getDescription());
            ps.setString(3, roomType.getType());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRoomType(RoomType roomType) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
                                                                      UPDATE 
                                                                        `room_type` 
                                                                      SET
                                                                        `capacity` = ?,
                                                                        `description` = ?,
                                                                        `type` = ? 
                                                                      WHERE `id` = ? ;
                                                                      """);
            ps.setInt(1, roomType.getCapacity());
            ps.setString(2, roomType.getDescription());
            ps.setString(3, roomType.getType());
            ps.setLong(4, roomType.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRoomType(RoomType roomType) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
                                                                      UPDATE 
                                                                        `room_type` 
                                                                      SET
                                                                        `deleted` = CURRENT_TIMESTAMP()
                                                                      WHERE `id` = ? ;
                                                                      """);
            ps.setLong(1, roomType.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ComboBoxList> list;

    @Override
    public ArrayList<RoomType> selectRoomType() {
        ArrayList<RoomType> list = new ArrayList<>();
        try {
            String query = """
                           SELECT 
                             `id`,
                             `capacity`,
                             `description`,
                             `type` 
                           FROM
                             `room_type` WHERE `room_type`.`deleted` IS NULL  ORDER BY `room_type`.`type` ASC ;
                           """;
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                RoomType c = new RoomType();
                c.setId(rs.getLong("ID"));
                c.setCapacity(rs.getInt("CAPACITY"));
                c.setDescription(rs.getString("DESCRIPTION"));
                c.setType(rs.getString("TYPE"));
                list.add(c);
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
    public void comboBoxRoomType() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("""
                                                  SELECT 
                                                    `id`,
                                                    `capacity`,
                                                    `description`,
                                                    `type` 
                                                  FROM
                                                    `room_type` WHERE `room_type`.`deleted` IS NULL  ORDER BY `room_type`.`type` ASC ;
                                                  """);
            rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                String namel = rs.getString("TYPE");
                this.getList().add(new ComboBoxList(idl, namel));
            }
            rs.close();
            statement.close();
            closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
