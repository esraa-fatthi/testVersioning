package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistiryPage {

   public Driver driver;

    By pageTitle = By.xpath("(//h2[@class=\"title text-center\"])[1]");
    By fillInPassword = By.id("password");
    By fillInFirstName = By.id("first_name");
    By fillInLastName = By.id("last_name");
    By fillInAddress = By.id("address1");
    By fillInState = By.id("state");
    By fillInCity = By.id("city");
    By fillInZipCode = By.xpath("//input[@data-qa=\"zipcode\"]");
    By fillInMobNum = By.xpath("//input[@data-qa=\"mobile_number\"]");
    By ClickOnCreateAccountBtn = By.xpath("//button[@data-qa=\"create-account\"]");


    public RegistiryPage(Driver driver){
        this.driver=driver;
    }

/*******************************************Assertions*****************************************/

   public RegistiryPage CheckThatRegisteryPageIsLoadedSuccessfully() {
       Assert.assertTrue(driver.get().getCurrentUrl().contains("/signup"));
       Assert.assertEquals(driver.element().getTextOf(pageTitle),"ENTER ACCOUNT INFORMATION") ;
        return this;
   }



/*******************************************Actions*****************************************/

    public RegistiryPage fillInPW(String PassW){
        driver.element().fillFields(fillInPassword, PassW);
        return this;
    }
    public RegistiryPage fillInFN (String FN){
        driver.element().fillFields(fillInFirstName,FN);
        return this;
    }

    public RegistiryPage fillInLN (String LN) {
        driver.element().fillFields(fillInLastName,LN);
        return this;
    }

    public RegistiryPage fillInAddress (String Address){

        driver.element().fillFields(fillInAddress,Address);
        return this;
    }


    public RegistiryPage selectDropDown (String dropdown){

        WebElement selectDropDown = driver.get().findElement(By.id("country"));
        Select select = new Select(selectDropDown);
        select.selectByValue(dropdown);
        return this;

    }
    public RegistiryPage fillInState (String State){

        driver.element().fillFields(fillInState,State);
        return this;
    }

    public RegistiryPage fillInCity (String City) {
        driver.element().fillFields(fillInCity,City);
        return this;
    }

    public RegistiryPage fillInZipCode (String ZipCode){
        driver.element().fillFields(fillInZipCode,ZipCode);
        return this;
    }
    public RegistiryPage fillInMobNum (String MobNum){
        driver.element().fillFields(fillInMobNum,MobNum);
        return this;
    }
    public RegisterationSuccessPage ClickOnCreateAccountBtn(){
        driver.element().click(ClickOnCreateAccountBtn);
        return new RegisterationSuccessPage(driver);
    }


}
