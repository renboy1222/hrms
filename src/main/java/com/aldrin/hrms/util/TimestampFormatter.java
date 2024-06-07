/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms.util;

/**
 *
 * @author Java Programming with Aldrin
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TimestampFormatter {

    private String formattedTimestamp;

    public TimestampFormatter(String inputTimestamp) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Parse the input timestamp to LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(inputTimestamp, inputFormatter);

        // Define the output format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");

        // Format the LocalDateTime to the desired output format
        String formattedTimestamp = dateTime.format(outputFormatter);
        setFormattedTimestamp(formattedTimestamp);
    }

//    public static void main(String[] args) {
//        // Input timestamp
//        String inputTimestamp = "2024-05-19 17:45:00";
//
//        // Define the input format
//        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        // Parse the input timestamp to LocalDateTime
//        LocalDateTime dateTime = LocalDateTime.parse(inputTimestamp, inputFormatter);
//
//        // Define the output format
//        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
//
//        // Format the LocalDateTime to the desired output format
//        String formattedTimestamp = dateTime.format(outputFormatter);
//
//        // Print the formatted timestamp
//        System.out.println(formattedTimestamp);
//    }
}
