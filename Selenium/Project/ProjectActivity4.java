package testNGTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectActivity4 {
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
	        String expectedHeading="Quia quis non";
	    /*	String heading = driver.findElement(By.xpath("//div/main/article/div/h2")).getText();           
	        //Print title of new page
	        System.out.println("New page 2nd heading is: " + heading);*/
	        
	        //Verifying the heading
	        List<WebElement> elements = driver.findElements(By.xpath("//div/main/article/div/h2"));
	        for(WebElement element : elements) {
	            System.out.println(element.getText()); // just to show that it prints text
	            Assert.assertEquals( element.getText(), expectedHeading);
	        }
	        
	     //   Assert.assertEquals( heading, expectedHeading);
	    }

	    @AfterMethod
	    public void afterMethod() {
	        //Close the browser
	        driver.quit();
	    }

}
