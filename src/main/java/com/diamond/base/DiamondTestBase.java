package com.diamond.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DiamondTestBase {

    protected static WebDriver diamondDriver = null;
    public static final Props props =Props.getInstance();

    public DiamondTestBase()  {

    }


   @BeforeClass
    public static void initBrowser()  {

        String browserType=props.getStringValue("browser");

        switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                diamondDriver = new ChromeDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                diamondDriver = new InternetExplorerDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                diamondDriver = new ChromeDriver();
                break;
        }
        diamondDriver.manage().window().maximize();
        diamondDriver.manage().deleteAllCookies();
        diamondDriver.manage().timeouts().implicitlyWait(props.getLongStringValue("implicit_wait"), TimeUnit.SECONDS);
    }

@AfterClass
    public void closeBrowser() {
        if (diamondDriver != null) {
            diamondDriver.close();
            diamondDriver.quit();
        }
    }
}


