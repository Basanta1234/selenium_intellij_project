package com.diamond.testcases.webtables;

import com.diamond.base.DiamondTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ReadTableDataWithColumnName extends DiamondTestBase {


    @Test
    public void readTableDataWithColumnName() throws InterruptedException {

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

        for (int r = 1; r <= totalRows; r++) {
            String dataXpath = getTableData(r, "Status");
            String myData = diamondDriver.findElement(By.xpath(dataXpath)).getText();
            System.out.println("My Data for Status is : " + myData);
        }

    }

    /*
    This method will
    take row number and
    column name as
    parameter and will generate
    dynamic xpath

     */
    private String getTableData(int row, String columnName) {

        return "//table[@id='resultTable']/tbody/tr[" + row + "]/td[count(//table[@id='resultTable']/thead/tr/th/a[text()='" + columnName + "']/../preceding-sibling::th[@rowspan='1'])+1]";
    }
}
