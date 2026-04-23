package org.uiframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.uiframework.Utils.WaitHelper;

public class pg04_rating_highDishes {

private WebDriver driver;
private WaitHelper wait;
    public pg04_rating_highDishes(WebDriver driver){
        this.driver=driver;
        this.wait= new WaitHelper(driver);
    }

    By click_food = By.xpath("//a[@title=\"Food\"]");
    By south_indian = By.cssSelector("img[alt=\"restaurants curated for south indian\"]");
    By filter_ratings = By.xpath("//div[contains(text(),'Filter')]");
    By rating_food = By.xpath("(//div[text()='Ratings'])[2]");
    By rating_4 = By.xpath("//label[text()='Ratings 4.0+']");
    By apply_click = By.xpath("//div[text()='Apply']");



    public void pages_selectRatings(){

        WebElement food_sec = wait.waitForElementClickable(click_food);
        food_sec.click();
        WebElement south_food = wait.waitForElementClickable(south_indian);
        south_food.isDisplayed();
        south_food.click();
        WebElement filter_click = wait.waitForElementClickable(filter_ratings);
       filter_click.isDisplayed();
       filter_click.click();
        WebElement rating_click = wait.waitForElementClickable(rating_food);
        rating_click.click();

        WebElement rating4_click = wait.waitForElementClickable(rating_4);
       boolean condition1 = rating4_click.isEnabled();
        System.out.println(condition1);
        if(!rating4_click.isSelected()){
            rating4_click.click();
        }
        System.out.println(rating4_click.isSelected());

        WebElement apply_filt = wait.waitForElementClickable(apply_click);
        apply_filt.click();






    }
}
