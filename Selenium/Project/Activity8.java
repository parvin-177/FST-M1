package LMSActivities;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    }

    @Test
    public void verifyThatRootUserLoginSuccessfully() {
        //  Find the username field and enter the username
        driver.findElement(By.xpath("//input[@id=\"user_login\"]")).sendKeys("root");

        //  Find the password field and enter the password
        driver.findElement(By.xpath("//input[@id=\"user_pass\"]")).sendKeys("pa$$w0rd");

        //Find the login button and click it.
        driver.findElement(By.xpath("//input[@id=\"wp-submit\"]")).click();

        //Verify that you have logged in

        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.className("//span[text()=\"root\"]"))).build().perform();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        WebElement logout= driver.findElement(By.xpath("//li[@id='wp-admin-bar-logout']"));
        System.out.println(logout.isDisplayed());
        Assert.assertTrue(logout.isDisplayed());
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}