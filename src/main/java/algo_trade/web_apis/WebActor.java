package algo_trade.web_apis;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * A class which allows another {@link WebDriver} to act on the internet in a more forseeable way. More proper comments might be added later on
 * @since 20-03-2025
 * @author Viktor
 * @version 1.0
 */
public class WebActor {

    /**
    * Clicks an element specified by it's xpath. Sometimes this might take some time since elements may take longer time to load in the browser.
    * That being said, this always works.
    * @param xpath The xpath of the desired element
    * @param driver The driver which should click the element 
    */
    protected final void click_element_xpath(String xpath, WebDriver driver) {
         try {
             driver.findElement(By.xpath(xpath)).click();
         }
         catch(Exception e) {
             System.out.println("Failure to find " + xpath);
             WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
             waiter.until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
             click_element_xpath(xpath, driver);
         }
 
    }

    /**
     * Inserts text into an input field identified by its xpath
     * @param input_xpatj The xpath of the input field.
     * @param text The text to insert.
     */
    @SuppressWarnings("UnnecessaryReturnStatement")
    protected final void insertIntoInputByXpath(String input_xpath, String text, WebDriver driver) {
        try{
            WebElement inputField = driver.findElement(By.xpath(input_xpath));
            inputField.clear();
            inputField.sendKeys(text);
            return;
        }
        catch(Exception e){
            System.out.println("Failure to find " + input_xpath);
            insertIntoInputByXpath(input_xpath, text, driver);
        }
    }

    /**
     * Gives you an element in the driver-view based on it's xpath
     * @param xpath The path of the web element
     * @param driver The driver which get's the element
     * @return The element wished for. 
     */
    protected final WebElement get_element_xpath(String xpath, WebDriver driver) {
    try {
        return driver.findElement(By.xpath(xpath));
        
    } catch (Exception e) {
            return get_element_xpath(xpath, driver);
        }
    }
    
    /**
     * Clicks an element based on it's id
     * @param id The id of the element you wish to click on
     * @param driver The driver which should click it
     */
    private void click_element_id(String id, WebDriver driver){
    try {
        driver.findElement(By.id(id)).click();
    } catch (Exception e) {
        click_element_id(id, driver);
    }
    }
}
