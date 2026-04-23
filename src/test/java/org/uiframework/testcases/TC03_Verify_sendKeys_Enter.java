package org.uiframework.testcases;

import org.testng.annotations.Test;
import org.uiframework.Base.BaseTest;
import org.uiframework.driver.DriverManager;
import org.uiframework.pages.pg03_senskeys_enter;

public class TC03_Verify_sendKeys_Enter extends BaseTest {

    @Test
    public void test_send_enter(){
        pg03_senskeys_enter pg03SenskeysEnter = new pg03_senskeys_enter(DriverManager.getDriver());

        pg03SenskeysEnter.searchPizza();
    }
}
