package tests;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utilities.ScreenshotManger;


import java.time.Duration;

public class ContactUsTest {

ThreadLocal<Driver> driver;
@BeforeClass
@Parameters(value = {"BrowserName"})
    public void setUp(@Optional("CHROME") String BrowserName) {
    driver = new ThreadLocal<>();
    driver.set(new Driver(BrowserName));
    driver.get().get().manage().window().maximize();
    driver.get().get().navigate().to("https://automationexercise.com/");
    driver.get().get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
//    driver.get().element().hoverOnItem(By.xpath("(//div[@class=\"product-overlay\"])[1]")).
//    click(By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[1]"));
}
@Test
public void contactUsTest(){
   new HomePage(driver.get()).CheckThatUserNavigatedToHomepage()
   .ClickOnContactUsLink().CheckContactUsPageIsLoadedSuccessfully()
   .fillInContactUsForm("Esraa","shhs@gamil.com","hi","welcome")
   .clickOnSubmitBtn().CheckFormSubmittedSuccessfully().clickOnHomeBtn()
           .CheckThatUserNavigatedToHomepage();
    ScreenshotManger.captureScreenshot(driver.get().get(), "Contact-us-Test");
                           }
//@Test
//public void checkFailure(ITestResult result){
//    if (result.getStatus()==ITestResult.FAILURE){
//        System.out.println("Test Failed");
//        System.out.println("Taking Screenshot..");
//        ScreenshotManger.captureScreenshot(driver.get(), result.getName());
//
//    }}


@AfterClass
 public void tearDown(){
   driver.get().get().manage().deleteAllCookies();
   driver.get().quit();
 }
}

