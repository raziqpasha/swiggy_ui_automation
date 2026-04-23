package org.uiframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.uiframework.Utils.WaitHelper;

import java.util.List;

public class PG02_Enter_Location {

    WebDriver driver;
    public PG02_Enter_Location(WebDriver driver){
        this.driver=driver;
    }

    By location = By.xpath("//input[@id=\"location\"]");
By listloc = By.cssSelector("div.kuQWc>span._2OORn");

    public void test_location(){
        WebElement loc = driver.findElement(location);
        loc.sendKeys("Bangalore");
        List<WebElement>  listoflocs = driver.findElements(listloc);
        System.out.println(listoflocs.get(0).getText());
        listoflocs.get(0).click();


    }

}
