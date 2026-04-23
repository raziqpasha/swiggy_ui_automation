package org.uiframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.uiframework.Utils.WaitHelper;
import org.uiframework.driver.DriverManager;

public class pg03_senskeys_enter {
    private WebDriver driver;
    private WaitHelper wait;

    public pg03_senskeys_enter(WebDriver driver){
        this.driver=driver;
        this.wait= new WaitHelper(driver);
    }

    By srch = By.xpath("//div[contains(text(),\"Search for restaurant, item or more\")]");
    By send_pizza = By.xpath("//input[@placeholder=\"Search for restaurants and food\"]");


    public void searchPizza(){
        WebElement srch_enter = wait.waitForElementClickable(srch);
        srch_enter.click();

        WebElement send_text = wait.waitForElementVisible(send_pizza);
        send_text.sendKeys("pizza");
        send_text.sendKeys(Keys.ENTER);
    }

}
