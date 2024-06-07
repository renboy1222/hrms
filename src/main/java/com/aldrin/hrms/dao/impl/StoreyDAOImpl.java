/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms.dao.impl;



import com.aldrin.hrms.dao.StoreyDAO;
import com.aldrin.hrms.model.Role;
import com.aldrin.hrms.model.Storey;
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
public class StoreyDAOImpl extends DBConnection implements StoreyDAO {

    @Override
    public void addStorey(Storey storey) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("INSERT INTO ROOM_STOREY(STOREY) VALUES  (?) ");
            ps.setString(1, storey.getStorey());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStorey(Storey storey) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE ROOM_STOREY SET STOREY =?  WHERE ROOM_STOREY.ID = ?");
            ps.setString(1, storey.getStorey());
            ps.setLong(3, storey.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStorey(Storey storey) {
           try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE ROOM_STOREY SET DELETED =? WHERE ROOM_STOREY.ID = ? ");
            ps.setBoolean(1, true);
            ps.setLong(2, storey.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ComboBoxList> list;

    @Override
    public ArrayList<Storey> selectStorey() {
            ArrayList<Storey> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM `room_storey`  WHERE `room_storey`.`deleted` IS NULL ORDER BY ID ASC  ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Storey c = new Storey();
                c.setId(rs.getLong("ID"));
                c.setStorey(rs.getString("STOREY"));
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
    public void comboBoxStorey() {
    this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("SELECT * FROM ROOM_STOREY  WHERE `room_storey`.`deleted` IS NULL  ORDER BY ID ASC ");
            rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                String namel = rs.getString("STOREY");
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
