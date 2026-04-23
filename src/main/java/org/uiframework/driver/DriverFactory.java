package org.uiframework.driver;


import org.uiframework.Utils.PropertiesReader;
import org.uiframework.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Arrays;

public class DriverFactory {

    public static void initDriver() {

        String browser = PropertiesReader.get("browser"); // Read browser from config
        boolean headless = Boolean.parseBoolean(PropertiesReader.get("headless")); // Convert string to boolean

        WebDriver driver; // Declare driver

        switch (browser) {

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions(); // Chrome options


                chromeOptions.addArguments("--disable-blink-features=AutomationControlled");

                chromeOptions.addArguments("--start-maximized");

                chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));

                chromeOptions.setExperimentalOption("useAutomationExtension", false);



                if (headless) {
                    chromeOptions.addArguments("--headless=new"); // Enable headless
                }
                driver = new ChromeDriver(chromeOptions); // Launch Chrome
                break;

            case "edge":
                driver = new EdgeDriver(); // Launch Edge
                break;

            case "firefox":
                driver = new FirefoxDriver(); // Launch Firefox
                break;

            default:
                throw new RuntimeException("Invalid browser in config"); // Fail if invalid
        }

        driver.manage().window().maximize(); // Maximize window

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(Integer.parseInt(PropertiesReader.get("implicitWait"))) // Set wait
        );

        DriverManager.setDriver(driver); // Store driver in ThreadLocal
    }

    public static void quitDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit(); // Close browser
            DriverManager.unload(); // Remove driver
        }
    }
}
