package org.uiframework.Base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.uiframework.Utils.AllureEnvWriter;
import org.uiframework.Utils.PropertiesReader;
import org.uiframework.driver.DriverFactory;
import org.uiframework.driver.DriverManager;
import org.uiframework.listeners.RetryListener;
import org.uiframework.listeners.TestListener;

@Listeners({io.qameta.allure.testng.AllureTestNg.class,TestListener.class, RetryListener.class})
public class BaseTest {

    @BeforeMethod
    public void setUp() {

        DriverFactory.initDriver();
        // 🔥 IMPORTANT → create env file before test
        AllureEnvWriter.writeEnvironment();

        DriverManager.getDriver().get(PropertiesReader.get("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}