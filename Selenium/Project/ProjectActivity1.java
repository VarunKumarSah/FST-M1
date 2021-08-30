package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectActivity1 {
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
	        String title = driver.getTitle();
	                   
	        //Print title of new page
	        System.out.println("New page title is: " + title);
	        
	        //Verifying the title 
	        Assert.assertEquals( title, "Alchemy Jobs – Job Board Application");
	    }

	    @AfterMethod
	    public void afterMethod() {
	        //Close the browser
	        driver.quit();
	    }


}
