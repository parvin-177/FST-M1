package LMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Baseclass {
    public WebDriver driver = null;
    public WebDriverWait wait = null;
    public String marker = "---------------------------------";
    public String contactFullName = "John Doe";
    public String email = "johndoe@gmail.com";
    public String subject = "Login Issue";
    public String message = "Login is not working. Ticket created";


    @BeforeMethod
    public void launchBrowser() throws Exception {
        setDriver(Configurator.createChromeDriver());
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getDriver().get(Configurator.LMS_URL);
    }

    @AfterMethod
    public void closeBrowser() throws Exception {
        getDriver().quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    private void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriverWait getWaiter() {

        return wait;
    }
    private void setWaiter() {
        this.wait=wait;

    }
}
