package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectActivity6 {
WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs");
        
    }

    @Test
    public void TestCase1() throws InterruptedException {
        // Check the title of the page
    	driver.findElement(By.xpath("//div/div[3]/div/nav/div/ul/li[1]/a")).click();
        String title = driver.getTitle();
                   
        //Print title of new page
        System.out.println("New page title is: " + title);
        
        //Verifying the title 
        Assert.assertEquals( title, "Jobs – Alchemy Jobs");
        
        driver.findElement(By.name("search_keywords")).sendKeys("Banking");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div/main/article/div/div/form/div[1]/div[4]/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("company")).click();
        Thread.sleep(1000);
       // driver.findElement(By.className("application_button button")).click();
      //  Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/div/div[3]/input")).click();
        Thread.sleep(1000);
        String eMailAddress= driver.findElement(By.className("job_application_email")).getText();
        System.out.println("Email Address is: " +eMailAddress);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
