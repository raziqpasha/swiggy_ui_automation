package org.uiframework.Utils;

import io.qameta.allure.Allure;

import java.io.FileInputStream;
import java.io.InputStream;

public class LogUtils {

    public static void attachLog(String testName) {

        try {
            InputStream is = new FileInputStream("logs/" + testName + ".log");

            Allure.addAttachment("Execution Logs", is);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}