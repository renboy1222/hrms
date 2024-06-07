/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms.util;

import com.aldrin.hrms.dao.impl.DBConnection;
import static com.aldrin.hrms.dao.impl.DBConnection.getCon;
import java.sql.ResultSet;
import java.sql.Statement;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Java Programming with Aldrin
 */
@Setter
@Getter
@ToString
public class CurrentHourAndTime extends DBConnection {
    
    private String currentTime;

    public CurrentHourAndTime selectHourAndMinutes() {
       CurrentHourAndTime currentTime = null;
        try {
            String query = """
                       SELECT CURRENT_TIME() AS TIMENA
                       """;
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                CurrentHourAndTime ct = new CurrentHourAndTime();
                ct.setCurrentTime(rs.getString("TIMENA"));
                currentTime = ct;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentTime;
    }
}
