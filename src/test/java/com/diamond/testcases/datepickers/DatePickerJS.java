package com.diamond.testcases.datepickers;

import com.diamond.base.DiamondTestBase;
import diamondpages.CheckBoxDemoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DatePickerJS extends DiamondTestBase {

    private static void enterDateUsingJs(WebDriver driver, String dateStr, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', '" + dateStr + "')", element);
    }

    @Test
    public void runTest1() throws InterruptedException {

        diamondDriver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
        WebElement datePicker = diamondDriver.findElement(By.cssSelector("div.input-group.date>input"));
        datePicker.click();
        datePicker.clear();
        String myDate = "27/02/1992";
        enterDateUsingJs(diamondDriver, myDate, datePicker);
        Thread.sleep(5000);

    }
}
