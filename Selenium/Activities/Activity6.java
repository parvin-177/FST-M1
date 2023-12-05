package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity6 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Actions object
        Actions actions = new Actions(driver);

        // Open the page
        driver.get("https://www.training-support.net/selenium/input-events");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Press the key
        actions.sendKeys("B").build().perform();
        // Press CTRL+A and CTRL+C
        //actions.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        //SHIFT+a->print A
        actions.keyDown(Keys.SHIFT).sendKeys("a").build().perform();
        String keyPressed = driver.findElement(By.id("keyPressed")).getText();
        System.out.println(keyPressed);
        actions.keyDown(Keys.CANCEL).build().perform();

        // Close the browser
        driver.close();
    }
}