package com.ims.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();

    static {
        try{
            FileInputStream fis = new FileInputStream("configuration.properties");

            properties.load(fis);
        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
