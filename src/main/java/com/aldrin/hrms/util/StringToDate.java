/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Java Programming with Aldrin
 */
public class StringToDate {

    // Desired date pattern
    static String pattern = "yyyy-MM-dd HH:mm:ss";

    public StringToDate() {
    }

    public static Date convertStringToDate(String dateString) {
        // Create a SimpleDateFormat instance with the given pattern
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Parse the string into a Date object
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.err.println("ParseException: " + e.getMessage());
            return null;
        }
    }

    public static String convertDateToString(Date date) {
        // Create a SimpleDateFormat instance with the given pattern
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Format the Date object into a String
        return dateFormat.format(date);
    }

    public static String convertMMMddyyy(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM. dd,yyyy hh:mm a");
        return sdf.format(date);
    }
    
     public static String convertStringToFormattedDate(String date) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Parse the input date and time string to a LocalDateTime object
        LocalDateTime dateTime = LocalDateTime.parse(date, inputFormatter);

        // Define the output format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a");

        // Format the LocalDateTime object to the desired format
        String outputDateTime = dateTime.format(outputFormatter);
        return outputDateTime;
    }

}
