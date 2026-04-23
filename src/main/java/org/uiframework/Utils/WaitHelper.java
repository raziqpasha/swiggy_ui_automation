package org.uiframework.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitHelper {





    private WebDriver driver;
        private  WebDriverWait wait;

        // Constructor
        public WaitHelper(WebDriver driver){
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        // Wait for visibility
        public  WebElement waitForElementVisible(By locator) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        // Wait for clickability
        public  WebElement waitForElementClickable(By locator) {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        }

        // Wait for presence
    //WHEN TO USE
        //
        //👉 When element is in DOM but not visible yet
        //
        //Real Example:
        //Restaurant list loaded but not displayed fully
        public WebElement waitForElementPresent(By locator) {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }

        // Wait for text
    //WHEN TO USE
        //
        //👉 When text is updated dynamically
        //
        //Real Example:
        //Cart total updates after adding item
        public boolean waitForText(By locator, String text) {
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        }

        // Wait for URL
    //WHEN TO USE
        //
        //👉 After navigation or redirection
        //
        //✅ Usage Example
        //driver.findElement(By.xpath("//a[text()='Offers']")).click();
        //
        //wait.waitForUrlContains("offers");
        public boolean waitForUrlContains(String url) {
            return wait.until(ExpectedConditions.urlContains(url));
        }

        // Wait for invisibility
    //WHEN TO USE
        //
        //👉 When loader/spinner disappears
        //
        //✅ Usage Example
        //By loader = By.xpath("//div[@class='loading']");
        //
        //wait.waitForElementInvisible(loader);
        //
        //System.out.println("Page fully loaded");
        public boolean waitForElementInvisible(By locator) {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }





}
