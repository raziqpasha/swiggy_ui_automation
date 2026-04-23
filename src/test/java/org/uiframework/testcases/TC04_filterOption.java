package org.uiframework.testcases;

import org.testng.annotations.Test;
import org.uiframework.Base.BaseTest;
import org.uiframework.driver.DriverManager;
import org.uiframework.pages.pg04_rating_highDishes;

public class TC04_filterOption extends BaseTest {

    @Test
    public void test_filter(){

        pg04_rating_highDishes pg = new pg04_rating_highDishes(DriverManager.getDriver());
        pg.pages_selectRatings();
    }

}
