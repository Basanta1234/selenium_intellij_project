package com.diamond.base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class DiamondTestBase {

    public static final Props props = Props.getInstance();
    public static final Logger LOG = LogManager.getLogger(DiamondTestBase.class.getName());
    protected static WebDriver diamondDriver = null;

    public DiamondTestBase() {

    }


    @BeforeClass
    public static void initBrowser() {

        String browserType = props.getStringValue("browser");
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


