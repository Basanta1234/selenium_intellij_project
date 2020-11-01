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
    protected static Properties diamondProp;

    public DiamondTestBase() {


        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "diamondconfiguration" + File.separator + "config.properties")) {
            diamondProp = new Properties();
            diamondProp.load(fis);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @BeforeClass
    public void initBrowser() {
        String browserType = diamondProp.getProperty("browser");


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
        diamondDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterClass
    public void closeBrowser() {
        if (diamondDriver != null) {
            diamondDriver.quit();
        }
    }
}


