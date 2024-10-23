package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class ProductPage {
    Driver driver;
    By productLink = By.xpath("//a[@href=\"/products\"]");
    By allProductsList = By.cssSelector("div.features_items");
    By viewProductLink = By.xpath("//a[@href=\"/product_details/1\"]");

    public ProductPage(Driver driver){
        this.driver=driver;}
/*******************************************Assertions*****************************************/
    public void checkProductPageIsLoaded(){
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/products"));
    }
    public void checkAllProductsList(){
        Assert.assertTrue(driver.element().isDisplayed(allProductsList));
    }
    public void checkProductTitleIsVisible(){

    }

/*******************************************Actions*****************************************/

        public void clickOnProductsLink(){
            driver.element().click(productLink);

        }

        public void clickOnViewProductLink(){
            driver.element().click(viewProductLink);
        }



}
