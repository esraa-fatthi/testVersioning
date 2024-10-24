package driverFactory;

import browserActions.BrowserActions;
import elementActions.ElementActions;
import listeners.webDriver.WebDriverListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class Driver {

    private ThreadLocal<WebDriver> driver;

   public Driver(String driverType) {

       WebDriver driverx = getDriver(driverType).startDriver();
       assert driverx != null;
       driver =new ThreadLocal<>();
       driver.set(new EventFiringDecorator<>(org.openqa.selenium.WebDriver.class,
                new WebDriverListener(driverx)).decorate(driverx));


   }

    private DriverAbstract getDriver(String driver){
        switch (driver){
            case "CHROME": {
                return new ChromeDriverFactory();
            }
            case "FIREFOX": {
                return new FirefoxDriverFactory();
            }
            case "EDGE": {
                return new EdgeDriverFactory();
            }
            default:{
                throw new IllegalStateException("Unexpected value: "+ driver);
            }

        }

    }

    public WebDriver get(){
        return driver.get();
    }
    public void quit(){
        driver.get().quit();
    }
    public ElementActions element(){
        return new ElementActions(driver.get());
    }
    public BrowserActions browser(){
        return new BrowserActions(driver.get());
    }


}
