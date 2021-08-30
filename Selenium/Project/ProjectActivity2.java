package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectActivity2 {
	 WebDriver driver;
	    
	    @BeforeMethod
	    public void beforeMethod() {
	        //Create a new instance of the Firefox driver
	        driver = new FirefoxDriver();
	        
	        //Open browser
	        driver.get("https://alchemy.hguy.co/jobs");
	    }

	    @Test
	    public void TestCase1() {
	        // Check the title of the page
	        String expectedHeading="Welcome to Alchemy Jobs";
	    	String heading = driver.findElement(By.className("entry-title")).getText();           
	        //Print title of new page
	        System.out.println("New page heading is: " + heading);
	        
	        //Verifying the heading  
	        Assert.assertEquals( heading, expectedHeading);
	    }

	    @AfterMethod
	    public void afterMethod() {
	        //Close the browser
	        driver.quit();
	    }

}
