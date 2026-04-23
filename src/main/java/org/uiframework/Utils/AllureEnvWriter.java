package org.uiframework.Utils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
public class AllureEnvWriter {

    public static void writeEnvironment() {

        try {
            // Create properties object
            Properties props = new Properties();

            // Read values from config.properties
            props.setProperty("Browser", PropertiesReader.get("browser")); // browser used
            props.setProperty("Environment", "QA"); // environment name (can make dynamic later)
            props.setProperty("URL", PropertiesReader.get("url")); // app URL
            props.setProperty("OS", System.getProperty("os.name")); // system OS
            props.setProperty("Java Version", System.getProperty("java.version")); // java version
            props.setProperty("Tester", "Raziq"); // tester name
            props.setProperty("Framework", "Selenium UI Automation"); // framework name

            // Ensure allure-results folder exists
            File dir = new File("allure-results");
            if (!dir.exists()) {
                dir.mkdirs(); // create folder if not exists
            }

            // Create environment.properties file inside allure-results
            FileWriter writer = new FileWriter(dir + "/environment.properties");

            // Write properties into file
            props.store(writer, "Allure Environment Details");

            writer.close(); // close file writer

        } catch (IOException e) {
            e.printStackTrace(); // print error if something fails
        }
    }

}
