package LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;

public class LMSProject extends LMS.Baseclass {

    /*
     * Verify the website title
     * Goal: Read the title of the website and verify the text
     */
    @Test
    public void VerifyWebsiteTitle() {
        String expectedWebTitle = "Alchemy LMS – An LMS Application";
        String actualWebTitle = getDriver().getTitle();
        assertEquals(actualWebTitle, expectedWebTitle,"Assert LMS Website Title");
    }
    /*
     * Verify the website heading
     * Goal: Read the heading of the website and verify the text
     */

    @Test
    public void VerifyWebsiteHeading() {
        String expectedWebHeading = "Learn from Industry Experts";
        String actualWebHeading = getDriver().findElement(By.className("uagb-ifb-title")).getText();
        assertEquals(actualWebHeading, expectedWebHeading,"Assert LMS Website Heading");
    }
    /*
     * Verify the title of the first info box
     * Goal: Read the title of the first info box on the website and verify the text
     */
    @Test
    public void VerifyInfoBox() {
        String expectedInfoBoxHeading = "Actionable Training";
        WebElement InfoBoxHeading = getDriver().findElement(By.xpath("//*[contains(text(),'Actionable Training')]"));
        String actualInfoBoxHeading = InfoBoxHeading.getText();
        assertEquals(actualInfoBoxHeading, expectedInfoBoxHeading,"Assert LMS Website Heading");
    }
	/*
	 * Verify the title of the second most popular course
	 * Goal: Read the title of the second most popular course on the website and verify the
       text
	 */

    @Test
    public void SecondPopularCourse() {
        String expectedPopularCourse = "Email Marketing Strategies";
        WebElement popularCourse = getDriver().findElement(By.xpath("//*[contains(text(),'Email Marketing Strategies')]"));
        String actualPopularCourse = popularCourse.getText();
        assertEquals(actualPopularCourse, expectedPopularCourse,"Assert LMS Website Heading");
    }
    /*
     * Navigate to another page
     * Goal: Navigate to the “My Account” page on the site.
     */
    @Test
    public void MyAccount() {

        WebElement myAccount = getDriver().findElement(By.linkText("My Account"));
        Actions builder = new Actions(getDriver());
        builder.click(myAccount);
        Action compAction = builder.build();
        compAction.perform();
        this.getWaiter().until(ExpectedConditions.titleIs("My Account – Alchemy LMS"));
    }
    /*
     * Logging into the site
     * Goal: Open the website and log-in using the provided credentials.
     */
    @Test
    public void Login() {

        getDriver().findElement(By.linkText("My Account")).click();
        this.getWaiter().until(ExpectedConditions.titleIs("My Account – Alchemy LMS"));
        WebElement login = getDriver().findElement(By.xpath("//div[2]/a"));
        login.click();
        WebElement userTextBox = getDriver().findElement(By.id("user_login"));
        WebElement passTextBox = getDriver().findElement(By.id("user_pass"));
        WebElement submitButton = getDriver().findElement(By.name("wp-submit"));
        Actions builder = new Actions(getDriver());
        builder.click(userTextBox).sendKeys(Configurator.USER_NAME).
                click(passTextBox).sendKeys(Configurator.PASSWORD).click(submitButton);
        Action compAction = builder.build();
        compAction.perform();
        this.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.className("ld-logout")));
    }
    /*
     * Count the number of courses
     * Goal: Navigate to the “All Courses” page and count the number of courses.
     */

    @Test
    public void FindAllCourses() {

        getDriver().findElement(By.linkText("All Courses")).click();
        this.getWaiter().until(ExpectedConditions.titleIs("All Courses – Alchemy LMS"));
        List<WebElement> allCourse = getDriver().findElements(By.cssSelector("h3[class='entry-title']"));
        int coursesCount = allCourse.size();
        System.out.println(marker);
        System.out.println("No Of courses available :"+coursesCount);
        System.out.println(marker);
        for(WebElement coursePrint : allCourse) {
            System.out.println(coursePrint.getText());
        }
        System.out.println(marker);
    }
    /*
     * Contact the admin
     * Goal: Navigate to the “Contact Us” page and complete the form.
     */

    @Test
    public void ContactAdmin() {
        getDriver().findElement(By.linkText("Contact")).click();
        this.getWaiter().until(ExpectedConditions.titleIs("Contact – Alchemy LMS"));
        WebElement fullName = getDriver().findElement(By.name("wpforms[fields][0]"));
        fullName.sendKeys(contactFullName);
        getDriver().findElement(By.name("wpforms[fields][1]")).sendKeys(email);
        getDriver().findElement(By.name("wpforms[fields][2]")).sendKeys(subject);
        getDriver().findElement(By.name("wpforms[fields][3]")).sendKeys(message);
        getDriver().findElement(By.cssSelector("button[name='wpforms[submit]']")).click();
        String successMessage = getDriver().findElement(By.id("wpforms-confirmation-8")).getText();
        //Print the message
        System.out.println("Message displayed after submission is: " +successMessage);
    }
    /*
     * Complete a simple lesson
     * Goal: Navigate to a particular lesson and complete it.
     */
    @Test
    public void CompleteLesson() {
        getDriver().findElement(By.linkText("My Account")).click();
        this.getWaiter().until(ExpectedConditions.titleIs("My Account – Alchemy LMS"));
        WebElement login = getDriver().findElement(By.xpath("//div[2]/a"));
        login.click();
        WebElement userTextBox = getDriver().findElement(By.id("user_login"));
        WebElement passTextBox = getDriver().findElement(By.id("user_pass"));
        WebElement submitButton = getDriver().findElement(By.name("wp-submit"));
        Actions builder = new Actions(getDriver());
        builder.click(userTextBox).sendKeys(Configurator.USER_NAME).
                click(passTextBox).sendKeys(Configurator.PASSWORD).click(submitButton);
        Action compAction = builder.build();
        compAction.perform();
        getDriver().findElement(By.linkText("All Courses")).click();
        this.getWaiter().until(ExpectedConditions.titleIs("All Courses – Alchemy LMS"));
        WebElement Mycourse = getDriver().findElement(By.xpath("//*[contains(text(),'See more...')]"));
        Mycourse.click();
        System.out.println(getDriver().getTitle());
        this.getWaiter().until(ExpectedConditions.titleIs("Social Media Marketing – Alchemy LMS"));
        getDriver().findElement(By.xpath("//*[contains(text(),'Investment & Marketing  Final Strategies')]")).click();
        this.getWaiter().until(ExpectedConditions.titleIs("Investment & Marketing Final Strategies – Alchemy LMS"));

        try{
            getDriver().findElement(By.xpath("//*[text()='Complete']"));
        }

        catch(NoSuchElementException e)
        {
            getDriver().findElement(By.xpath("//*[@value='Mark Complete']")).click();
        }
        System.out.println(getDriver().getTitle()+" is completed");
    }

}
