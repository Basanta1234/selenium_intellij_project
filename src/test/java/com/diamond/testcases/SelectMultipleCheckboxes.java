package com.diamond.testcases;

import com.diamond.base.DiamondTestBase;
import diamondpages.CheckBoxDemoPage;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SelectMultipleCheckboxes extends DiamondTestBase {


    public static void main(String[] args) {

        diamondDriver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        for (int i = 1; i < 6; i++) {
            System.out.println("(//input[@type='checkbox'])[" + i + "]");

            if (!diamondDriver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")).isSelected()) {
                diamondDriver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")).click();
            }
        }

    }
}
