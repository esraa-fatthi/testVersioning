package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ContactUsPage {
    public Driver driver;


    By formTitle = By.xpath("(//h2[@class=\"title text-center\"])[2]");
    By nameField = By.name("name");
    By emailField = By.name("email");
    By subjectField = By.name("subject");
    By messageField = By.id("message");
    By submitBtn = By.name("submit");
    By successMessage = By.cssSelector("div.status.alert.alert-success");
    By homeBtn = By.cssSelector("a.btn.btn-success");

/*******************************************Assertions*****************************************/
    public ContactUsPage CheckContactUsPageIsLoadedSuccessfully(){
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/contact_us"));
        Assert.assertEquals(driver.element().getTextOf(formTitle),"GET IN TOUCH");
             return this;
    }

    public  ContactUsPage CheckFormSubmittedSuccessfully(){
        Assert.assertEquals(driver.element().getTextOf(successMessage),"Success! Your details have been submitted successfully.");
             return this;
    }
/*******************************************Actions*****************************************/
    public ContactUsPage fillInContactUsForm(String name, String email, String subject, String message){
        driver.element().fillFields(nameField,name);
        driver.element().fillFields(emailField,email);
        driver.element().fillFields(subjectField,subject);
        driver.element().fillFields(messageField,message);
     return this;
    }

    public HomePage clickOnHomeBtn(){
        driver.element().click(homeBtn);
        return new HomePage(driver);
    }
    public ContactUsPage clickOnSubmitBtn(){
        driver.element().click(submitBtn);
        driver.get().switchTo().alert().accept();
        return this;
    }


    public ContactUsPage(Driver driver){
        this.driver=driver;
//        wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
//        fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
//                .pollingEvery(Duration.ofSeconds(10))
//                .ignoring(NoSuchElementException.class);
    }
}
