package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LogInSignUpPage {

    public Driver driver;

    By loginEmail = By.xpath("//input[@data-qa=\"login-email\"]");
    By loginpassword = By.name("password");
    By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");

    By signUpFormTitle = By.xpath("(//h2)[3]");
    By signUpName = By.name("name");
    By signUpEmail = By.xpath("//input[@data-qa=\"signup-email\"]");
    By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");


public LogInSignUpPage(Driver driver){
    this.driver= driver;
}
/*******************************************Assertions*****************************************/
 public LogInSignUpPage  CheckUserNavigatedToLogInSignUpPage () {

     Assert.assertTrue(driver.get().getCurrentUrl().contains("/login"));
     Assert.assertEquals(driver.element().getTextOf(signUpFormTitle),"New User Signup!");
       return this;
    }

/*******************************************Actions*****************************************/

 public LogInSignUpPage fillInLogInEmail(String Email){
     driver.element().fillFields(loginEmail, Email);
     return this;
 }
 public LogInSignUpPage fillInLoginPassword (String Password){
     driver.element().fillFields(loginpassword, Password);
     return this;
    }

 public HomePage ClickOnLogInBtn () {
     driver.element().click(loginButton);
     return new HomePage(driver);
 }

 public LogInSignUpPage fillInSignUpEmail (String Email){

        driver.element().fillFields(signUpEmail,Email);
        return this;
 }


 public LogInSignUpPage fillInsignUpName (String Name){

        driver.element().fillFields(signUpName,Name);
        return this;
    }

 public RegistiryPage ClickOnSignupBtn () {
        driver.element().click(signUpButton);
        return new RegistiryPage(driver);
    }

}
