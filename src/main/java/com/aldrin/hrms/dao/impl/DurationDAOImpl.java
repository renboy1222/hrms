/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms.dao.impl;

import com.aldrin.hrms.dao.DurationDAO;
import com.aldrin.hrms.model.Duration;
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
public class DurationDAOImpl extends DBConnection implements DurationDAO {

    @Override
    public void addDuration(Duration duration) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("INSERT INTO `duration` (`duration`,`minutes`) VALUES(?,?) ;");
            ps.setString(1, duration.getDuration());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDuration(Duration duration) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE `duration` SET `duration` = ?,  `minutes`=?   WHERE `id` = ? ;");
            ps.setString(1, duration.getDuration());
            ps.setInt(2, duration.getMinutes());
            ps.setLong(3, duration.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDuration(Duration duration) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE DURATION SET `deleted` = CURRENT_TIMESTAMP()  WHERE DURATION.ID = ? ");
            ps.setLong(1, duration.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ComboBoxList> list;

    @Override
    public ArrayList<Duration> selectDuration() {
        ArrayList<Duration> list = new ArrayList<>();
        try {
            String query = "SELECT `id`,`duration`,`minutes` FROM   `duration` WHERE `deleted` IS NULL ORDER BY id ASC;";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Duration duration = new Duration();
                duration.setId(rs.getLong("ID"));
                duration.setDuration(rs.getString("DURATION"));
                duration.setMinutes(rs.getInt("MINUTES"));
                list.add(duration);
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
    public void comboBoxDuration() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("SELECT `id`,`duration` FROM   `duration` WHERE `deleted` IS NULL ORDER BY id ASC");
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

}
