package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegisterationSuccessPage {
    public Driver driver;
    private WebDriverWait wait;

      By successMessage = By.xpath("//h2[@data-qa=\"account-created\"]");
      By continueBtn = By.xpath("//a[@data-qa=\"continue-button\"]");

    public RegisterationSuccessPage(Driver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
    }

/*******************************************Assertions*****************************************/
 public RegisterationSuccessPage CheckThatSuccessMessageDisplayed () {

     wait.until(ExpectedConditions.urlContains("/account_created"));
     wait.until(ExpectedConditions.visibilityOf(driver.get().findElement(successMessage)));



     Assert.assertTrue(driver.get().getCurrentUrl().contains("/account_created"));
  Assert.assertTrue(driver.element().isDisplayed(successMessage));
  Assert.assertEquals(driver.element().getTextOf(successMessage), "ACCOUNT CREATED!");
   return this;
 }

/*******************************************Actions*****************************************/
 public HomePage ClickOnContinueBtn(){
     driver.element().click(continueBtn);
     return new HomePage(driver);
 }
}
