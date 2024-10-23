package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    public Driver driver;
    By logoutLink = By.xpath("(//a[@href=\"/\"])[1]");
    By loginLink = By.xpath("//a[@href=\"/login\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");
    By contactUsLink = By.xpath("//a[@href=\"/contact_us\"]");

    public HomePage(Driver driver){
    this.driver=driver;
}
/*******************************************Assertions*****************************************/
    public HomePage CheckThatLogoutLinkIsDisplayed (){
        Assert.assertEquals(driver.element().getTextOf(logoutLink),"Home");
        return this;
    }
    public HomePage CheckThatLoginLinkIsDisplayed (){
        Assert.assertTrue(driver.element().isDisplayed(loginLink));
        return this;
    }
    public HomePage CheckThatdeleteAccountLinkIsDisplayed (){
        Assert.assertTrue(driver.element().isDisplayed(deleteAccountLink));
        return this;
    }
    public HomePage CheckThatUserNavigatedToHomepage(){
        Assert.assertEquals(driver.get().getCurrentUrl(),"https://automationexercise.com/");
        return this;
    }
/*******************************************Actions*****************************************/
    public LogInSignUpPage ClickOnLoginLink(){
        driver.element().click(loginLink);
        return new LogInSignUpPage(driver);
    }
    public LogInSignUpPage ClickOnLogoutLink(){
        driver.element().click(logoutLink);
        return new LogInSignUpPage(driver);
    }
    public AccountSuccessfulDeletion ClickOndeleteAccountLink(){
        driver.element().click(deleteAccountLink);
        return new AccountSuccessfulDeletion(driver);
    }
    public ContactUsPage ClickOnContactUsLink(){
        driver.element().click(contactUsLink);
        return new ContactUsPage(driver);
    }
}
