package tests;

import driverFactory.Driver;
import pages.HomePage;
import pages.LogInSignUpPage;
import pages.ProductDetailsPage;
import pages.ProductPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductPageTest {
    Driver driver;
    HomePage homePage;
    ProductPage productPage;
    LogInSignUpPage logInSignUpPage;
    ProductDetailsPage productDetailsPage;


    @BeforeClass
  public void setUp(){
      driver = new Driver("CHROME");
      driver.get().navigate().to("https://automationexercise.com/login");
      driver.get().manage().window().maximize();
  }
 @Test
public void productPageTest(){
        homePage = new HomePage(driver);
       productPage = new ProductPage(driver);
       productDetailsPage = new ProductDetailsPage(driver);


homePage.CheckThatUserNavigatedToHomepage();
productPage.clickOnProductsLink();
productPage.checkProductPageIsLoaded();
productPage.clickOnViewProductLink();
productDetailsPage.checkProductDetailsPageIsLoadedSuccessfully();


 }


 @AfterClass
public void tearDown(){
 driver.get().manage().deleteAllCookies();
  driver.quit();
 }
}
