package com.diamond.testcases.datepickers;


import com.diamond.base.DiamondTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class DatePickerWithBestPractice extends DiamondTestBase {
    /*

   This method calculate
   the month difference
   between system date
   and date expected
    */

    private static boolean increment = false;

    private static int getMonthDifference(String expectedDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        int monthDiff = 0;
        int totalMonthDiff = 0;
        try {
            LocalDate localDate = LocalDate.parse(expectedDate, formatter);
            LocalDate currentDate = LocalDate.now();
            long monthsBetween = ChronoUnit.MONTHS.between(
                    YearMonth.from(currentDate),
                    YearMonth.from(localDate)
            );
            monthDiff = (int) monthsBetween;

            if (monthDiff > 0) {
                monthDiff = monthDiff;
                increment = true;
            } else if (monthDiff < 0) {
                monthDiff= Math.abs(monthDiff);
                increment = false;
            }

        } catch (DateTimeParseException e) {
            System.out.println("Some thing went wrong converting String input to date " + e.getMessage());
        }

        return monthDiff;
    }


    /*
    This method extracts
    days to click from
    the expected date
     */
    private static String getExpectedDays(String expectedDate) {
        String[] dateArray = expectedDate.split("/");
        return dateArray[1];
    }

    @Test
    public void clickOnDatePickerCalendar() throws InterruptedException {

        String expectedDate = "08/13/2038";
        String days = getExpectedDays(expectedDate);
        int monthDifference = getMonthDifference(expectedDate);

/*
        diamondDriver.get("https://jqueryui.com/datepicker/");
        diamondDriver.switchTo().frame(diamondDriver.findElement(By.cssSelector("iframe.demo-frame")));
       */
        diamondDriver.get("http://jqueryui.com/resources/demos/datepicker/other-months.html");
        diamondDriver.findElement(By.cssSelector("input#datepicker")).click();

                for(int i=0; i<monthDifference; i++){
                    if (!increment) {
                WebElement prevButton = diamondDriver.findElement(By.cssSelector("a[title='Prev']>span"));
                prevButton.click();
            } else {
                WebElement nextButton = diamondDriver.findElement(By.cssSelector("a[title='Next']>span"));
                nextButton.click();
            }
        }
        diamondDriver.findElement(By.linkText(days)).click();
        Thread.sleep(2000);
    }

}