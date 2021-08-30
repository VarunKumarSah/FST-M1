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

public class ProjectActivity2 {
	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException, InterruptedException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "PixelEmulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
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
    	driver.findElementByAccessibilityId("New text note").click();
        Thread.sleep(5000);
        // Find the first name, last name, and phone number fields
        MobileElement Title= driver.findElementById("com.google.android.keep:id/editable_title");
         MobileElement Notes = driver.findElementById("com.google.android.keep:id/edit_note_text");
        // Enter the text in the fields
         Title.sendKeys("Google Keep");
        Thread.sleep(5000);
        Notes.sendKeys("Google Keep Activity is in progress");
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
   
 

        // Assertion
       String Task1 = driver.findElementByXPath("//androidx.cardview.widget.CardView[@content-desc=\"Google Keep. Google Keep Activity is in progress. \"]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[2]").getText();
        Assert.assertEquals(Task1, "Google Keep Activity is in progress");
        
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
