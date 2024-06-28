/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms.dao.impl;

import com.aldrin.hrms.dao.RoomRateDAO;
import com.aldrin.hrms.model.Duration;
import com.aldrin.hrms.model.Room;
import com.aldrin.hrms.model.RoomRate;
import com.aldrin.hrms.model.RoomType;
import com.aldrin.hrms.util.ComboBoxList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class RoomRateDAOImpl extends DBConnection implements RoomRateDAO {

    @Override
    public void addRoomRate(RoomRate roomRate) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
INSERT INTO `room_rate` (
  `price`,
  `room_id`,
  `duration_id`,
  `down_payment`,refundable) VALUES(?,?,?,?,?) ;
                                                                      """);
            ps.setFloat(1, roomRate.getPrice());
            ps.setLong(2, roomRate.getRoom().getId());
            ps.setLong(3, roomRate.getDuration().getId());
            ps.setFloat(4, roomRate.getDown_payment());
            ps.setFloat(5, roomRate.getRefundable());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRoomRate(RoomRate roomRate) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
                                                                      UPDATE 
                                                                        `room_rate` 
                                                                      SET
                                                                        `price` = ?,
                                                                        `room_id` = ?,
                                                                        `duration_id` = ?,
                                                                        `down_payment` = ?, refundable =?  
                                                                        WHERE `id` = ? ;
                                                                      """);
            ps.setFloat(1, roomRate.getPrice());
            ps.setLong(2, roomRate.getRoom().getId());
            ps.setLong(3, roomRate.getDuration().getId());
            ps.setFloat(4, roomRate.getDown_payment());
            ps.setFloat(5, roomRate.getRefundable());
            ps.setLong(6, roomRate.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRoomRate(RoomRate roomRate) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE DURATION SET IN_ACTIVE =CURRENT_TIMESTAMP() WHERE DURATION.ID = ? ");
            ps.setLong(1, roomRate.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ComboBoxList> list;

    @Override
    public ArrayList<RoomRate> selectRoomRate() {
        ArrayList<RoomRate> list = new ArrayList<>();
        try {
            String query = """
                           SELECT
                               `room_rate`.`id`
                               , `room_rate`.`price`
                               , `room_rate`.`room_id`
                               , `room_rate`.`duration_id`
                               , `room_rate`.`down_payment`
                               , `room_rate`.`refundable`
                               , `duration`.`duration`
                               , `room`.`room_number`
                           FROM
                               `room_rate`
                               INNER JOIN `room` 
                                   ON (`room_rate`.`room_id` = `room`.`id`)
                               INNER JOIN `duration` 
                                   ON (`room_rate`.`duration_id` = `duration`.`id`) WHERE `room_rate`.`in_active` IS NULL ORDER BY `room`.`room_number` ASC 
                           """;
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                RoomRate rr = new RoomRate();
                Room r = new Room();
                Duration d = new Duration();
                rr.setId(rs.getLong("ID"));
                rr.setRefundable(rs.getFloat("REFUNDABLE"));
                r.setId(rs.getLong("ROOM_ID"));
                r.setRoomNumber(rs.getString("ROOM_NUMBER"));
                rr.setRoom(r);
                rr.setPrice(rs.getFloat("PRICE"));
                d.setDuration(rs.getString("DURATION"));
                d.setId(rs.getLong("DURATION_ID"));
                rr.setDuration(d);
                rr.setDown_payment(rs.getFloat("DOWN_PAYMENT"));
                list.add(rr);
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
    public void comboBoxRoomRate() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("SELECT * FROM ROLE WHERE ROLE.ACTIVE=TRUE  ORDER BY ROLE ASC ");
            rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                String namel = rs.getString("ROLE");
                this.getList().add(new ComboBoxList(idl, namel));
            }
            rs.close();
            statement.close();
            closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void comboBoxRoomDuration(RoomRate roomId) {
        System.out.println("room id+:" + roomId.getRoom().getId());
        this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("""
 SELECT   `room_rate`.`id`
           , `duration`.`duration`
           FROM
            `room_rate`
              INNER JOIN `room` 
               ON (`room_rate`.`room_id` = `room`.`id`)
              INNER JOIN `duration` 
                ON (`room_rate`.`duration_id` = `duration`.`id`) WHERE `room_rate`.`in_active` IS NULL AND`room_rate`.`room_id` =? ORDER BY `room`.`room_number` ASC                                                 
                                                  """);
            statement.setLong(1, roomId.getRoom().getId());
            rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                String namel = rs.getString("DURATION");
                this.getList().add(new ComboBoxList(idl, namel));
            }
            rs.close();
            statement.close();
            closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public RoomRate selectDurationToDisplayPriceDownPayment(RoomRate roomRate) {
        RoomRate rr = null;
        try {
            String query = "SELECT \n"
                    + "    `room_rate`.`id`\n"
                    + "    , `room_rate`.`price`\n"
                    + "    , `room_rate`.`down_payment`\n"
                    + "        FROM\n"
                    + "     `room_rate`\n"
                    + "          INNER JOIN `room` \n"
                    + "          ON (`room_rate`.`room_id` = `room`.`id`)\n"
                    + "            INNER JOIN `duration` \n"
                    + "          ON (`room_rate`.`duration_id` = `duration`.`id`) WHERE `room_rate`.`in_active` IS NULL AND`room_rate`.`id` =" + roomRate.getId() + " ORDER BY `room`.`room_number` ASC";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                RoomRate rRate = new RoomRate();
                rRate.setPrice(rs.getFloat("PRICE"));
                rRate.setDown_payment(rs.getFloat("DOWN_PAYMENT"));
                rr = rRate;
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rr;
    }

    public String selectEndDate(String startDate, String hours) {
        String start = null;
        try {
            String query = "";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                start = rs.getString("");
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return start;
    }

    @Override
    public String calculateMinutesToCheckOutDuration(RoomRate roomRate, String checkOutDate) {
        String rr = null;
        try {
            String query = "SELECT  \n"
                    + "    DATE_ADD('" + checkOutDate + "', INTERVAL `duration`.`minutes`  MINUTE) AS checkOut\n"
                    + "     FROM \n"
                    + "    `room_rate`\n"
                    + "    INNER JOIN `room` \n"
                    + "        ON (`room_rate`.`room_id` = `room`.`id`)\n"
                    + "    INNER JOIN `room_status` \n"
                    + "        ON (`room`.`status_id` = `room_status`.`id`)\n"
                    + "    INNER JOIN `room_storey` \n"
                    + "        ON (`room`.`storey_id` = `room_storey`.`id`)\n"
                    + "    INNER JOIN `room_type` \n"
                    + "        ON (`room`.`type_id` = `room_type`.`id`)\n"
                    + "    INNER JOIN `duration` \n"
                    + "        ON (`room_rate`.`duration_id` = `duration`.`id`)  WHERE `room_rate`.`in_active` IS NULL AND`room_rate`.`id` =" + roomRate.getId() + " ORDER BY `room`.`room_number` ASC";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

//                rRate.setPrice(rs.getFloat("PRICE"));
                rr = rs.getString("checkOut");
//                rr = rRate;
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rr;
    }

    @Override
    public RoomRate selectRoomInfo(RoomRate roomRate) {
        RoomRate rr = null;
        try {
            String query = "SELECT\n"
                    + "    `room`.`room_number`\n"
                    + "    , `room_type`.`type`\n"
                    + "    , `room_type`.`capacity`\n"
                    + "FROM\n"
                    + "    `room_rate`\n"
                    + "    INNER JOIN `room` \n"
                    + "        ON (`room_rate`.`room_id` = `room`.`id`)\n"
                    + "    INNER JOIN `room_status` \n"
                    + "        ON (`room`.`status_id` = `room_status`.`id`)\n"
                    + "    INNER JOIN `room_storey` \n"
                    + "        ON (`room`.`storey_id` = `room_storey`.`id`)\n"
                    + "    INNER JOIN `room_type` \n"
                    + "        ON (`room`.`type_id` = `room_type`.`id`)\n"
                    + "    INNER JOIN `duration` \n"
                    + "        ON (`room_rate`.`duration_id` = `duration`.`id`) WHERE `room_rate`.`id` =" + roomRate.getId() + " AND `room_rate`.`in_active` IS NULL ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                RoomRate rRate = new RoomRate();
                Room room = new Room();
                RoomType roomType = new RoomType();
                roomType.setCapacity(rs.getInt("CAPACITY"));
                roomType.setType(rs.getString("TYPE"));
                room.setRoomType(roomType);
                room.setRoomNumber(rs.getString("ROOM_NUMBER"));
                rRate.setRoom(room);
//                rRate.setPrice(rs.getFloat("PRICE"));
//                rRate.setDown_payment(rs.getFloat("DOWN_PAYMENT"));
                rr = rRate;
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rr;
    }

    @Override
    public Long getMaxId() {
        Long maxId = null;
        try {
            getDBConn();
            PreparedStatement statement = getCon().prepareStatement("SELECT \n"
                    + "    MAX(ROOM_RATE.ID) AS ID  \n"
                    + "FROM \n"
                    + "    ROOM_RATE ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                if (idl == 0) {
                    maxId = 0L;
                } else {
                    maxId = idl;
                }
            }
            rs.close();
            statement.close();
//            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return maxId;
    }

}
