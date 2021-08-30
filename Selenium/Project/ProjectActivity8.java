package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectActivity8 {

WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        
    }

    @Test
    public void TestCase1() throws InterruptedException {
        // Check the title of the page
    	driver.findElement(By.id("user_login")).sendKeys("root");
    	driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
    	driver.findElement(By.xpath("/html/body/div[1]/form/div/div/button/span")).click();
    			Thread.sleep(10000);
    	driver.findElement(By.id("wp-submit")).click();
    	String title = driver.getTitle();
    	System.out.println("You have succefully loged in into :"+title);
    	 Thread.sleep(10000);
    }
 
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
