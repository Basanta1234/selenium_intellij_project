package com.diamond.testcases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateDemo {


    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("MMM dd, YYYY");
        System.out.println(dtf1.format(ldt));//Dec 22, 2020
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MMM,YYYY");
        System.out.println(dtf2.format(ldt));//Dec,2020
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("MM/dd/YYYY");
        System.out.println(dtf3.format(ldt));//12/22/2020
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("MM-dd-YYYY");
        System.out.println(dtf4.format(ldt));//12-22-2020
        DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("MM/dd/YY");
        System.out.println(dtf5.format(ldt));//122220
        /*
        convert String data to date
         */
        String dateStrAlu = "122220";
        LocalDateTime ltd12 = LocalDateTime.parse(dateStrAlu, dtf5);
        System.out.println(ltd12);
    }
}
