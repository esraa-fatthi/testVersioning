package pages;

import driverFactory.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductDetailsPage {
    Driver driver;


    public ProductDetailsPage(Driver driver) {
        this.driver = driver;
    }


/*******************************************Assertions*****************************************/
    public void checkProductDetailsPageIsLoadedSuccessfully() {
        Assert.assertEquals(driver.get().getCurrentUrl(), "https://automationexercise.com/product_details/1");
    }
}