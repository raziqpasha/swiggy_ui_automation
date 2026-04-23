package org.uiframework.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>(); // Thread-safe storage

    public static WebDriver getDriver() {
        return driver.get(); // Get driver for current thread
    }

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance); // Set driver for current thread
    }

    public static void unload() {
        driver.remove(); // Remove driver after test
    }

}
