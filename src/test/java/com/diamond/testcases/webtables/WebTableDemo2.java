package com.diamond.testcases.webtables;

import com.diamond.base.DiamondTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class WebTableDemo2 extends DiamondTestBase {

    @Test
    public void printEnabledStatusFromTable() throws InterruptedException {

        diamondDriver.get("https://opensource-demo.orangehrmlive.com/");
        diamondDriver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
        diamondDriver.findElement(By.cssSelector("input#txtPassword")).sendKeys("admin123");
        diamondDriver.findElement(By.cssSelector("input#btnLogin")).click();

        //Actions actions = new Actions(diamondDriver);
        WebElement ele = diamondDriver.findElement(By.cssSelector("ul#mainMenuFirstLevelUnorderedList>li:first-child>a.firstLevelMenu"));
        ele.click();
        diamondDriver.findElement(By.cssSelector("a#menu_admin_UserManagement")).click();
        diamondDriver.findElement(By.cssSelector("a#menu_admin_viewSystemUsers")).click();
        int totalRows = diamondDriver.findElements(By.cssSelector("#resultTable>tbody>tr")).size();
        System.out.println("Total number of rows : " + totalRows);

        int counter = 0;
        for (int r = 1; r <= totalRows; r++) {
            WebElement statusColumn = diamondDriver.findElement(By.cssSelector("#resultTable>tbody>tr:nth-child(" + r + ")>td:nth-child(5)"));
            if (statusColumn.getText().equalsIgnoreCase("enabled")) {
                counter++;

            }
        }
        System.out.println("Total number of Enabled status is : " + counter);
        System.out.println("Total number of disabled  status is : " + (totalRows - counter));
    }
}
