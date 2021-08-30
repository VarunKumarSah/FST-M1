import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ProjectActivity1 {
	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException, InterruptedException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "PixelEmulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
        Thread.sleep(5000);

    }

    @Test
    public void googleTaskTest() throws InterruptedException {
    	// Click on add new contact floating button
       // driver.findElementByid().click();
    	driver.findElementByAccessibilityId("Create new task").click();
        Thread.sleep(5000);
        // Find the first name, last name, and phone number fields
         MobileElement TaskName1 = driver.findElementByXPath("//android.widget.EditText[@text='New task']");
        // Enter the text in the fields
        TaskName1.sendKeys("Complete Activity with Google Tasks");
        Thread.sleep(5000);
        driver.findElementByXPath("//android.widget.Button[@text='Save']").click();
        Thread.sleep(5000);
        driver.findElementByAccessibilityId("Create new task").click();
        Thread.sleep(5000);
        // Find the first name, last name, and phone number fields
         MobileElement TaskName2 = driver.findElementByXPath("//android.widget.EditText[@text='New task']");
        // Enter the text in the fields
        TaskName2.sendKeys("Complete Activity with Google Keep");
        Thread.sleep(5000);
        driver.findElementByXPath("//android.widget.Button[@text='Save']").click();
        Thread.sleep(5000);
        driver.findElementByAccessibilityId("Create new task").click();
        Thread.sleep(5000);
        // Find the first name, last name, and phone number fields
         MobileElement TaskName3 = driver.findElementByXPath("//android.widget.EditText[@text='New task']");
        // Enter the text in the fields
        TaskName3.sendKeys("Complete the second Activity Google Keep");
        Thread.sleep(5000);
         driver.findElementByXPath("//android.widget.Button[@text='Save']").click();
        Thread.sleep(5000);
 

        // Assertion
       String Task1 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]/android.view.ViewGroup/android.widget.TextView").getText();
        Assert.assertEquals(Task1, "Complete Activity with Google Tasks");
        String Task2 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]/android.view.ViewGroup/android.widget.TextView").getText();
        Assert.assertEquals(Task2, "Complete Activity with Google Keep");
        String Task3 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]/android.view.ViewGroup/android.widget.TextView").getText();
        Assert.assertEquals(Task3, "Complete the second Activity Google Keep");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
