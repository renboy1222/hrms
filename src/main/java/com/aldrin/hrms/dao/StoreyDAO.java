/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.hrms.dao;

import com.aldrin.hrms.model.Storey;
import java.util.List;

/**
 *
 * @author ALDRIN B. C.
 */
public interface StoreyDAO {
     
//    add Storey
    public void addStorey(Storey storey);
    
//    update Storey
    public void updateStorey(Storey storey);
    
//    delete Storey
    public void deleteStorey(Storey storey);
    
//    list of Storey
    public List<Storey> selectStorey();
    
    public void comboBoxStorey();
}
