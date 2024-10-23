package listeners.testng;
import driverFactory.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ScreenshotManger;

import java.lang.reflect.Field;

public class TestNGListener implements ITestListener, IExecutionListener {

    @Override
    public void onExecutionStart(){
        System.out.println("Welcome to selenium");
    }


    @Override
    public void onExecutionFinish(){
        System.out.println("Generating report..");
        System.out.println("End of Execution");
    }


    @Override
    public void onTestStart(ITestResult result){
        System.out.println("*********** Start Of Test "+ result.getName()+ " ************");
    }


    @Override
    public void onTestSuccess(ITestResult result) {
     System.out.println("*********** Success Of Test "+ result.getName()+ " ************");
    }


    public void onTestFailure(ITestResult result){
        System.out.println("Test Failed");
        System.out.println("Taking screenshot");
        Driver driver = null;
        ThreadLocal<Driver> driverThreadLocal;
        Object currentClass = result.getInstance();
        Field[] fields = result.getTestClass().getRealClass().getDeclaredFields();

        try {
            for (Field field : fields) {
                if (field.getType() == Driver.class) {
                    driver = (Driver) field.get(currentClass);
                }

                if (field.getType() == ThreadLocal.class) {
                    driverThreadLocal = (ThreadLocal<Driver>) field.get(currentClass);
                    driver = driverThreadLocal.get();
                }
            }
        }
        catch(IllegalAccessException exception){
                System.out.println("Unable to get field, Field Should be public");
            }

            ScreenshotManger.captureScreenshot(driver.get(), result.getName());
            System.out.println("*********** Failure Of Test" + result.getName() + "************");


        }}
