package org.uiframework.testcases;

import org.testng.annotations.Test;
import org.uiframework.Base.BaseTest;
import org.uiframework.driver.DriverManager;
import org.uiframework.pages.PG02_Enter_Location;

import static org.uiframework.utils.AssertUtils.assertEquals;

public class TC02_Verify_First_Loc extends BaseTest {

    @Test
    public void test_loc(){
        PG02_Enter_Location pg02EnterLocation = new PG02_Enter_Location(DriverManager.getDriver());
        pg02EnterLocation.test_location();
    //    assertEquals("Bangalore Palace, Palace Cross Road, Vasanth Nagar, Bengaluru, Karnataka, India","Bangalore Palace, Palace Cross Road, Vasanth Nagar, Bengaluru, Karnataka, India","iam getting actual n expected values both r equal n verified as assertions");
    }
}
