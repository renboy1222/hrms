/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.hrms.dao;


import com.aldrin.hrms.model.Duration;
import java.util.List;

/**
 *
 * @author ALDRIN B. C.
 */
public interface DurationDAO {
     
//    add Role
    public void addDuration(Duration duration);
    
//    update Role
    public void updateDuration(Duration duration);
    
//    delete Role
    public void deleteDuration(Duration duration);
    
//    list of Role
    public List<Duration> selectDuration();
    
    public void comboBoxDuration();
}
