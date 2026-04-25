package org.uiframework.listeners;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int maxTry = 1; // retry count

    //👉 ITestResult is a TestNG interface (prebuilt)
    //ITestResult = "Test Report Object (for one test)"
    //-->It tells you:
    //✔ test name -->. result.getName()
    //✔ status (pass/fail) --> result.getStatus()
    //✔ error/exception  --> result.getThrowable()
   // Example:
   // AssertionError: expected true but found false

    //✔ execution time -->result.getStartMillis(),result.getEndMillis()
    //✔ method details  --> result.getMethod()

    @Override
    public boolean retry(ITestResult result) {

        if (count < maxTry) {
            count++;
            return true; // retry test
        }
        return false; // final failure
    }
}
