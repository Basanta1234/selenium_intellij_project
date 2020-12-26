package com.diamond.testcases.datepickers;

import com.diamond.base.DiamondTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DatePickerForFutureDate extends DiamondTestBase {


    @Test
    public void runTest1() throws InterruptedException {

        diamondDriver.getCurrentUrl();
        // declare variable

        String month = "March,2025";
        String dateStr = "17";
        diamondDriver.get("https://www.phptravels.net/home");
        WebElement checkIn = diamondDriver.findElement(By.cssSelector("input#checkin"));
        checkIn.click();
        //String textDate=diamondDriver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[1]/nav/div[2]")).getText();

        while (true) {
            String textDate = diamondDriver.findElement(By.xpath("//*[@id='datepickers-container']/div[1]/nav/div[2]")).getText();
            String[] dStr = textDate.split("\n");
            String myStr = dStr[0] + dStr[1];
            System.out.println("Date from website is : " + myStr);
            if (myStr.equalsIgnoreCase(month)) {
                break;
            } else {
                diamondDriver.findElement(By.cssSelector("div[class='datepicker--nav-action'][data-action='next']")).click();
            }

        }
        diamondDriver.findElement(By.xpath("//*[@id='datepickers-container']/div[1]/div/div/div[2]/div[contains(text(),'" + dateStr + "')]")).click();
    }
}