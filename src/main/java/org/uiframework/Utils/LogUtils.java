package org.uiframework.Utils;

import io.qameta.allure.Allure;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class LogUtils {

    public static void attachLog(String testName) {

        try {
            File logFile = new File("logs/" + testName + ".log");

            if (!logFile.exists()) {
                return; // avoid crash
            }

            FileInputStream fis = new FileInputStream(logFile);

            Allure.addAttachment("Logs - " + testName, fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}