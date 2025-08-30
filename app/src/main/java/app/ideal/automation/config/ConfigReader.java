package app.ideal.automation.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties props = new Properties();

    //Static block is used, so that the config file will only load once
    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getter method to return property by key
    public static String get(String key) {
        return props.getProperty(key);
    }
}
