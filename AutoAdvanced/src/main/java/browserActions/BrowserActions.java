package browserActions;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class BrowserActions {
    private WebDriver driver;

    public BrowserActions (WebDriver driver){
        this.driver=driver;
    }

    public BrowserActions navigateToUrl (String url){
        driver.get(url);
        return this;
    }

    public BrowserActions navigateForward (){
        driver.navigate().forward();
        return this;
    }

    public BrowserActions getTOUrl ( String url){
        driver.get(url);
        return this;
    }

    public BrowserActions getCurrentUrl (){
        driver.getCurrentUrl();
        return this;
    }

    public BrowserActions navigateBack (){
        driver.navigate().back();
        return this;
    }
    public BrowserActions refreshCurrentPage (){
        driver.navigate().refresh();
        return this;
    }
    public BrowserActions addCookie (Cookie cookie){
        driver.manage().addCookie(cookie);
        return this;
    }
    public BrowserActions DeleteCookieByName (String cookie){
        driver.manage().deleteCookieNamed(cookie);
        return this;
    }
    public BrowserActions DeleteCookie (Cookie cookie){
        driver.manage().deleteCookie(cookie);
        return this;
    }
    public BrowserActions DeleteAllCookies (){
        driver.manage().deleteAllCookies();
        return this;
    }
    public BrowserActions scrollToAmount(int hight, int width){
        new Actions(driver).scrollByAmount(hight,width).build().perform();
        return this;
    }

    public BrowserActions scrolltoButtom(){
        new Actions(driver).scrollByAmount(0,2500).build().perform();
        return this;
    }

}
