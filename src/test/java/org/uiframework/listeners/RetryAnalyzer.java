package org.uiframework.listeners;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int maxTry = 1; // retry count

    @Override
    public boolean retry(ITestResult result) {

        if (count < maxTry) {
            count++;
            return true; // retry test
        }
        return false; // final failure
    }
}
