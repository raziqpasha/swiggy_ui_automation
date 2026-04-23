package org.uiframework.testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.uiframework.Base.BaseTest;
import org.uiframework.driver.DriverManager;
import org.uiframework.utils.AssertUtils;

public class TC01_launch_and_verify extends BaseTest {

    @Description("verify the swiggy launches and home page title")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void test_launchswiggyANDverifyHomePage() {
        String title = DriverManager.getDriver().getTitle();
        //Assert.assertTrue(title.contains("Swiggy"));
        AssertUtils.assertTrue(title.contains("Swiggy"), "Verify homepage");

    }
}