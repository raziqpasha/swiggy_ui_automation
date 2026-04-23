package org.uiframework.listeners;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.uiframework.driver.DriverManager;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {
    public static void attachScreenshot(String testName) {
        if (DriverManager.getDriver() == null) return;

        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
                .format(new Date());

        String fileName = testName + "_" + timestamp + ".png";

        // Take screenshot
        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.BYTES);

        // ✅ Attach to Allure
        Allure.addAttachment(fileName, new ByteArrayInputStream(screenshot));

        // ✅ Save to local folder
        try {
            File file = new File("screenshots/" + fileName);
            file.getParentFile().mkdirs();

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(screenshot);
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
