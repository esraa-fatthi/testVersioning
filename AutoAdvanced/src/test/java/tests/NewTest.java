package tests;

//import Pages.LogInSignUpPage;

import driverFactory.Driver;
import pages.*;
import org.testng.annotations.*;

public class NewTest {

    Driver driver;


    @BeforeClass
    public void setUp(){
        driver = new Driver("CHROME");
        driver.get().navigate().to("https://automationexercise.com");
        driver.get().manage().window().maximize();
     // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test(priority = 1)
    public void userCanRegisterSuccessfully(){

        new HomePage(driver).CheckThatUserNavigatedToHomepage().ClickOnLoginLink().
CheckUserNavigatedToLogInSignUpPage().fillInSignUpEmail("111123s1112421s@gmail.com").fillInsignUpName("Esraa")
   .ClickOnSignupBtn().CheckThatRegisteryPageIsLoadedSuccessfully().fillInPW("12345").
     fillInFN("Esraa").fillInLN("Fathy").fillInAddress("Alexandria").fillInCity("Alex").
            fillInState("Alex").selectDropDown("Singapore").fillInMobNum("01246555").
            fillInZipCode("2342342").ClickOnCreateAccountBtn().
             CheckThatSuccessMessageDisplayed();

     driver.get().manage().deleteAllCookies();
    }
    @Test(priority = 2, dependsOnMethods = "userCanRegisterSuccessfully")
    public void userCanLoginSuccessfully() {
       driver.get().navigate().to("https://automationexercise.com/login");


       new LogInSignUpPage(driver).fillInLogInEmail("111123s1112421s@gmail.com").
      fillInLoginPassword("12345").ClickOnLogInBtn().//CheckThatLogoutLinkIsDisplayed();
                    driver.get().manage().deleteAllCookies();

    }
    @Test(priority = 3, dependsOnMethods = "userCanLoginSuccessfully")
    public void UserCanLogOutSuccessfully(){

      //  new HomePage(driver).ClickOnLogoutLink();//CheckUserNavigatedToLogInSignUpPage();

    }
    @Test(priority = 4, dependsOnMethods = "UserCanLogOutSuccessfully")

    public void userCanDeleteAccountSuccessfully() {

        new HomePage(driver).ClickOnLoginLink().fillInLogInEmail("111123s1112421s@gmail.com").
                     fillInLoginPassword("12345").ClickOnLogInBtn().
     ClickOndeleteAccountLink().checkThatAccountShouldBeDeletedSuccessfully()
            .clickOnContinueButton().CheckThatUserNavigatedToHomepage().
                CheckThatLoginLinkIsDisplayed();

    }
    @AfterClass
    public void tearDown(){
        driver.get().manage().deleteAllCookies();
        //   driver.quit();
    }
}
