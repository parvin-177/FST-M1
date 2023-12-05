package LMSActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void ClickOnJobMenuSearchJob() {
        //click the menu item that says “Post a Job”
        driver.findElement(By.id("menu-item-26")).click();

        //Fill in the necessary details and click the button that says “Preview”.
        driver.findElement(By.xpath("//input[@id='create_account_email']")).sendKeys("abc5@ambrino.com");
        driver.findElement(By.xpath("//input[@id='job_title']")).sendKeys("Test123");
        driver.findElement(By.xpath("//input[@id='job_location']")).sendKeys("Kolkata");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        driver.findElement(By.xpath("//iframe[@id='job_description_ifr']")).sendKeys("None");
        driver.findElement(By.xpath("//input[@id='application']")).sendKeys("https://www.ambrino.com");
        driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys("AMBRINO");

        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("//input[@name='submit_job']")).click();

        //Click on the button that says “Submit Listing”.
        driver.findElement(By.xpath("//input[@id='job_preview_submit_button']")).click();

        //Verify that the job listing was posted by visiting the jobs page
        String s= driver.findElement(By.xpath("//div[@class='entry-content clear']")).getText();
        System.out.println(s);
        Assert.assertEquals("Job submitted successfully. Your listing will be visible once approved.", s);

        // Search for a particular job and wait for listings to show
        driver.findElement(By.id("menu-item-24")).click();
        driver.findElement(By.xpath("//input[@id='search_keywords']")).sendKeys("Test123");
        driver.findElement(By.xpath("//input[@id='search_location']")).sendKeys("Kolkata");
        driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();

    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
