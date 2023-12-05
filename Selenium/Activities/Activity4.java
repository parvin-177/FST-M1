package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://www.training-support.net/selenium/target-practice");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Find the first header and print its text
        String firstHeaderText = driver.findElement(By.xpath("//h1[text()='First header']")).getText();
        System.out.println(firstHeaderText);
        // Find the Second header and print its colour
        String secondHeaderColor = driver.findElement(By.xpath("//h2[@class='ui orange header']")).getCssValue("color");
        System.out.println(secondHeaderColor);

        // Find the violet button and print its classes
        String orangeButtonClass = driver.findElement(By.xpath("//button[text()='Orange']")).getAttribute("class");
        System.out.println(orangeButtonClass);
        // Find the grey button and print its text
        String greenButtonText = driver.findElement(By.xpath("//button[text()='Green']")).getText();
        System.out.println(greenButtonText);

        // Close the browser
        driver.close();
    }
}