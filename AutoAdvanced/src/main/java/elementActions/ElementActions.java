package elementActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ElementActions {
    private WebDriver driver;

    public ElementActions(WebDriver driver){
        this.driver=driver;
    }

    public ElementActions hoverOnItem(By locator){
        new Actions(driver).scrollToElement(driver.findElement(locator)).build().perform();
        return this;
    }

    public ElementActions click(By locator){
    driver.findElement(locator).click();
    return this;
    }
    public ElementActions fillFields(By locator, String text){
        driver.findElement(locator).sendKeys(text);
        return this;
    }
    public ElementActions clear(By locator){
        driver.findElement(locator).clear();
        return this;
    }
    public String getTextOf(By locator){
        return driver.findElement(locator).getText();
    }
    public boolean isDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }
    public ElementActions scrollToElement(By locator){
        new Actions(driver).scrollToElement(driver.findElement(locator)).build().perform();
        return this;
    }
}

