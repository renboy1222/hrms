/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms.model;


import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author ALDRIN B. C.
 */
@Setter
@Getter
@ToString
public class Duration {
    
    private Long id;
    private String duration;
    private Date deleted;
    private Integer minutes;
    

}
