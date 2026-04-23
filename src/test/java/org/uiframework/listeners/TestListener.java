package org.uiframework.listeners;


import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.uiframework.Utils.LogManagerUtil;
import org.uiframework.Utils.LogUtils;
import org.uiframework.driver.DriverManager;

public class TestListener implements ITestListener {

    private static final Logger log = LogManager.getLogger(TestListener.class);

    // ========================= TEST START =========================
    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getName();
        // Set test name for log file
        LogManagerUtil.setTestName(testName);

        log.info("========= TEST STARTED: " + result.getName() + " =========");
        Allure.step("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogManagerUtil.clear();

        log.info("========= TEST PASSED: " + result.getName() + " =========");
        Allure.step("Test Passed: " + result.getName());

        // Optional → attach logs for success
        // LogUtils.attachLog();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogManagerUtil.clear();

        log.error("========= TEST FAILED: " + result.getName() + " =========");

        boolean isFinalFailure = isFinalFailure(result);

        if (isFinalFailure) {

            log.error("Final failure detected → capturing screenshot");

            // Screenshot
            ScreenshotUtils.attachScreenshot(result.getName());

            // Page Source (VERY IMPORTANT)
            Allure.addAttachment(
                    "Page Source",
                    "text/html",
                    DriverManager.getDriver().getPageSource(),
                    ".html"
            );

            // Error message
            if (result.getThrowable() != null) {
                String errorMsg = result.getThrowable().getMessage();
                log.error("Error: " + errorMsg);
                Allure.step("Error: " + errorMsg);
            }

            // ✅ Attach logs ONLY here
            LogUtils.attachLog(result.getName());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogManagerUtil.clear();

        log.warn("========= TEST SKIPPED: " + result.getName() + " =========");
        Allure.step("Test Skipped: " + result.getName());
    }
    // ========================= HELPER METHOD =========================
    private boolean isFinalFailure(ITestResult result) {

        // If no retry analyzer is attached → it's final failure
        if (result.getMethod().getRetryAnalyzer(result) == null) {
            return true;
        }

        try {
            // Get retry analyzer instance
            RetryAnalyzer retry = (RetryAnalyzer) result
                    .getMethod()
                    .getRetryAnalyzer(result);

            // If retry returns false → no retries left → final failure
            return !retry.retry(result);

        } catch (Exception e) {
            // If any issue → treat as final failure (safe fallback)
            return true;
        }
    }

}