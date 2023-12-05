package activities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test (groups = { "All" })
    public void testCase1() {
        //This test case will pass
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "Target Practice");
    }

    @Test (groups = { "All" })
    public void testCase2() {
        //This test case will Fail
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "black");
    }

    @Test (groups = { "All" })
    public void testCase11() {
        //This test case will Fail
        WebElement graybutton = driver.findElement(By.cssSelector("button.grey"));
        Assert.assertTrue(graybutton.isDisplayed());
        Assert.assertEquals(graybutton.getText(), "Grey");
    }

    @Test (groups = { "All" })
    public void testCase12() {
        //This test case will Fail
        WebElement yellowbutton = driver.findElement(By.cssSelector("button.yellow"));
        Assert.assertTrue(yellowbutton.isDisplayed());
        Assert.assertEquals(yellowbutton.getText(), "Yellow");
    }
    @Test (groups = { "All" })
    public void testCase13() {
        //This test case will Fail
        WebElement redbutton = driver.findElement(By.cssSelector("button.ui.red.button"));
        Assert.assertTrue(redbutton.isDisplayed());
        Assert.assertEquals(redbutton.getText(), "Red");
    }
    @Test (groups = { "All" })
    public void testCase14() {
        //This test case will Fail
        WebElement orangebutton = driver.findElement(By.cssSelector("button.orange"));
        Assert.assertTrue(orangebutton.isDisplayed());
        Assert.assertEquals(orangebutton.getText(), "Orange");
    }
    @Test (groups = { "All" })
    public void testCase15() {
        //This test case will Fail
        WebElement olivebutton = driver.findElement(By.cssSelector("button.olive"));
        Assert.assertTrue(olivebutton.isDisplayed());
        Assert.assertEquals(olivebutton.getText(), "Olive");
    }
    @Test (groups = { "All" })
    public void testCase16() {
        //This test case will Fail
        WebElement greenbutton = driver.findElement(By.xpath("//div[1]/button[5]"));
        Assert.assertTrue(greenbutton.isDisplayed());
        Assert.assertEquals(greenbutton.getText(), "Green");
    }
    @Test (groups = { "All" })
    public void testCase17() {
        //This test case will Fail
        WebElement tealbutton = driver.findElement(By.cssSelector("button.teal"));
        Assert.assertTrue(tealbutton.isDisplayed());
        Assert.assertEquals(tealbutton.getText(), "Teal");
    }
    @Test (groups = { "All" })
    public void testCase18() {
        //This test case will Fail
        WebElement bluebutton = driver.findElement(By.cssSelector("button.blue"));
        Assert.assertTrue(bluebutton.isDisplayed());
        Assert.assertEquals(bluebutton.getText(), "Blue");
    }
    @Test (groups = { "All" })
    public void testCase19() {
        //This test case will Fail
        WebElement violetbutton = driver.findElement(By.cssSelector("button.violet"));
        Assert.assertTrue(violetbutton.isDisplayed());
        Assert.assertEquals(violetbutton.getText(), "Violet");
    }
    @Test (groups = { "All" })
    public void testCase20() {
        //This test case will Fail
        WebElement purplebutton = driver.findElement(By.cssSelector("button.purple"));
        Assert.assertTrue(purplebutton.isDisplayed());
        Assert.assertEquals(purplebutton.getText(), "Purple");
    }
    @Test (groups = { "All" })
    public void testCase21() {
        //This test case will Fail
        WebElement pinkbutton = driver.findElement(By.cssSelector("button.pink"));
        Assert.assertTrue(pinkbutton.isDisplayed());
        Assert.assertEquals(pinkbutton.getText(), "Pink");
    }

    @Test (groups = { "All" })
    public void testCase22() {
        //This test case will Fail
        WebElement brownbutton = driver.findElement(By.cssSelector("button.brown"));
        Assert.assertTrue(brownbutton.isDisplayed());
        Assert.assertEquals(brownbutton.getText(), "Brown");
    }
    @Test(enabled = false)
    public void testCase3() {
        //This test will be skipped and not counted
        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }

    @Test (groups = { "All" })
    public void testCase4() {
        //This test will be skipped and will be be shown as skipped
        throw new SkipException("Skipping test case");
    }

    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}