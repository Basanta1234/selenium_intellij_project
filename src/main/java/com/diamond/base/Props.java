package com.diamond.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Props extends DiamondTestBase{
    public static Props SINGLE_INSTANCE = null;
    public static Properties properties;

    private Props() {
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "diamondconfiguration" + File.separator + "config.properties")) {
            properties = new Properties();
            properties.load(fis);

        } catch (FileNotFoundException ex) {
           LOG.error("Error on file path : "+ex.getMessage());
        } catch (IOException e) {
            LOG.error("Input Output exception  : "+e.getMessage());
            e.printStackTrace();
        }
    }

    public static Props getInstance() {
        if (SINGLE_INSTANCE == null) {
            SINGLE_INSTANCE = new Props();
        }
        return SINGLE_INSTANCE;
    }

    public String getStringValue(String key) {
        return properties.getProperty(key);
    }

    public long getLongStringValue(String key) {
        String value = "";
        try {
            value = properties.getProperty(key);
            return Long.parseLong(value);
        } catch (NumberFormatException ex) {
          LOG.debug("String value of number is not real number: "+ex.getMessage());
        }
        return 0;
    }
}
