package utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by goncad on 28.11.2018.
 */
public class Configuration {
    private Properties configProp = new Properties();

    Configuration() {
        try {
            String configFile = "config.properties";
            configProp.load(ClassLoader.getSystemResourceAsStream(configFile));

        } catch (IOException e) {
            System.err.println("Cannot read config file");
        }
    }

    public String getProperty(String key) {
        return configProp.getProperty(key);
    }


}
