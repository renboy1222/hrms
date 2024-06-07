/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms.dao.impl;

import com.aldrin.hrms.dao.RoomStatusDAO;
import com.aldrin.hrms.model.RoomStatus;
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
public class RoomStatusDAOImpl extends DBConnection implements RoomStatusDAO {

    @Override
    public void addRoomStatus(RoomStatus roomStatus) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
INSERT INTO `room_status` (
  `description`,
  `status`
) 
VALUES
  (?,?) ;
                                                                      """);
            ps.setString(1, roomStatus.getDescription());
            ps.setString(2, roomStatus.getStatus());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRoomStatus(RoomStatus roomStatus) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
                                                                      UPDATE 
                                                                        `room_status` 
                                                                      SET
                                                                        `description` =?,
                                                                        `status` = ?
                                                                      WHERE `id` = ?;
                                                                      """);
            ps.setString(1, roomStatus.getDescription());
            ps.setString(2, roomStatus.getStatus());
            ps.setLong(3, roomStatus.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRoomStatus(RoomStatus roomStatus) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
                                                                      UPDATE 
                                                                        `room_status`
                                                                      SET
                                                                        `deleted` = CURRENT_TIMESTAMP()
                                                                      WHERE `id` = ? ;
                                                                      """);
            ps.setLong(1, roomStatus.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ComboBoxList> list;

    @Override
    public ArrayList<RoomStatus> selectRoomStatus() {
        ArrayList<RoomStatus> list = new ArrayList<>();
        try {
            String query = """
                           SELECT 
                             `id`,
                             `description`,
                             `status` 
                           FROM
                            `room_status` WHERE deleted IS NULL ORDER BY `status` ASC
                           """;
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                RoomStatus c = new RoomStatus();
                c.setId(rs.getLong("ID"));
                c.setStatus(rs.getString("STATUS"));
                c.setDescription(rs.getString("DESCRIPTION"));
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
    public void comboBoxRoomStatus() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("""
                                                  SELECT 
                                                    `id`,
                                                    `description`,
                                                    `status` 
                                                  FROM
                                                   `room_status` WHERE deleted IS NULL ORDER BY `status` ASC
                                                  """);
            rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                String namel = rs.getString("STATUS");
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
