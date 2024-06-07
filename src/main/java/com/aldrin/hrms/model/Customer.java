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
 * @author Java Programming with Aldrin
 */
@Setter
@Getter
@ToString
public class Customer {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private Date deleted;

}
