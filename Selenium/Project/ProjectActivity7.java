package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectActivity7 {
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
    	driver.findElement(By.xpath("//div/div[3]/div/nav/div/ul/li[3]/a")).click();
        String title = driver.getTitle();
        String jobtile="Selenium Project 12346";
                   
      
        
       
       //Filing up the form  
        driver.findElement(By.id("create_account_email")).sendKeys("varunkumarsah1124@gmail.com");
        driver.findElement(By.id("job_title")).sendKeys("Selenium Project 12346");
        driver.findElement(By.id("job_location")).sendKeys("Kolkata");
        driver.findElement(By.id("application")).sendKeys("varunkumarsah@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"job_description_ifr\"]")).sendKeys("This Job Is for candited having 2 years of exp");
        driver.findElement(By.id("company_name")).sendKeys("XYZ INFOTECH");
        driver.findElement(By.id("company_website")).sendKeys("https//:XYZINFOTECH.com");
        //Clicking on prevew button 
        driver.findElement(By.name("submit_job")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("continue")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div/div[3]/div/nav/div/ul/li[1]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("search_keywords")).sendKeys("Selenium Project 12346");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div/main/article/div/div/form/div[1]/div[4]/input")).click();
        Thread.sleep(1000);
        String joBName=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div/div/ul/li[1]/a/div[1]/h3")).getText();
        System.out.println("the Given Job Name is "+joBName);
    }
 
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
