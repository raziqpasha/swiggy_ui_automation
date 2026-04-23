package org.uiframework.Utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static Properties properties = new Properties();

    static {
        try {
            InputStream input = PropertiesReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException("config.properties not found");
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    // Get value using key
    public static String get(String key) {
        return properties.getProperty(key);
    }

}
