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
        LogManagerUtil.setTestName(testName);

        log.info("========= TEST STARTED: " + testName + " =========");
        Allure.step("Test Started: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        log.info("========= TEST PASSED: " + result.getName() + " =========");
        Allure.step("Test Passed: " + result.getName());

        // optional:
        // LogUtils.attachLog(result.getName());

        LogManagerUtil.clear();
    }

    @Override
    public void onTestFailure(ITestResult result) {

        log.error("========= TEST FAILED: " + result.getName() + " =========");

        boolean isFinalFailure = isFinalFailure(result);

        if (isFinalFailure) {

            ScreenshotUtils.attachScreenshot(result.getName());

            Allure.addAttachment(
                    "Page Source",
                    "text/html",
                    DriverManager.getDriver().getPageSource(),
                    ".html"
            );

            if (result.getThrowable() != null) {
                String errorMsg = result.getThrowable().getMessage();
                log.error(errorMsg);
                Allure.step("Error: " + errorMsg);
            }

            // ✅ Attach logs BEFORE clearing
            LogUtils.attachLog(result.getName());
        }

        // ✅ CLEAR AT END ONLY
        LogManagerUtil.clear();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        log.warn("========= TEST SKIPPED: " + result.getName() + " =========");
        Allure.step("Test Skipped: " + result.getName());

        LogManagerUtil.clear();
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