package com.diamond.testcases;

import com.diamond.base.DiamondTestBase;
import diamondpages.CheckBoxDemoPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


public class CheckBoxDemo extends DiamondTestBase {


    @Test
    public void runTest1()  {

        CheckBoxDemoPage cp = new CheckBoxDemoPage();
        diamondDriver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        cp.clickCheckBox();
        String actualText = cp.getConfirmationText();
        String expectedText = "Success - Check box is checked";
        Assert.assertEquals(expectedText, actualText);
    }
}
