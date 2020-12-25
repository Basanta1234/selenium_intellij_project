package com.diamond.testcases;

import com.diamond.base.DiamondTestBase;
import diamondpages.CheckBoxDemoPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckBoxDemo extends DiamondTestBase {

    @Test
    public void runTest1() throws InterruptedException {
        CheckBoxDemoPage cp = new CheckBoxDemoPage();
        diamondDriver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        for (int i = 1; i < 6; i++) {
            System.out.println("(//input[@type='checkbox'])[" + i + "]");

            if (!diamondDriver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")).isSelected()) {
                diamondDriver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")).click();
                Thread.sleep(4000);
            }
        }

    }

}

