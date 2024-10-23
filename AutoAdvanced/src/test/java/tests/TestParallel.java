package tests;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import pages.HomePage;

import java.time.Duration;

public class TestParallel {

    public ThreadLocal<Driver> driver;

    @BeforeClass
    @Parameters(value = {"BrowserName"})
    public void setUp(@Optional("CHROME") String BrowserName) {
        driver = new ThreadLocal<>();
        driver.set(new Driver(BrowserName));
        driver.get().get().manage().window().maximize();
        driver.get().get().navigate().to("https://automationexercise.com/");
        driver.get().get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

    }

    @Test
    public void contactUsTest() throws InterruptedException {
        driver.get().element().hoverOnItem(By.xpath("(//div[@class=\"product-overlay\"])[1]"))
                .click(By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[1]"));
        Thread.sleep(5000);

        new HomePage(driver.get()).CheckThatUserNavigatedToHomepage()
                .ClickOnContactUsLink()
                .CheckContactUsPageIsLoadedSuccessfully()
                .fillInContactUsForm("Mohammed", "test12345@gmail.com", "Test", "Welcome")
                .clickOnSubmitBtn()
                .CheckFormSubmittedSuccessfully()
                .clickOnHomeBtn()
                .CheckThatUserNavigatedToHomepage();



    }

//    @AfterMethod
//    public void screenshotOnFailure(ITestResult result) {
//
//        if(result.getStatus() == ITestResult.FAILURE){
//            System.out.println("Test Failed");
//            System.out.println("Taking screen shot.....");
//            ScreenShotManager.captureScreenshot(driver.get(), result.getName());
//        }
//
//    }

    @AfterClass
    public void tearDown() {
        driver.get().get().manage().deleteAllCookies();
        driver.get().quit();
    }
}