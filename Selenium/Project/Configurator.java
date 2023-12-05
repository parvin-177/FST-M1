package LMS;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

public class Configurator {

    public static String driver_DIR = System.getProperty("user.dir")
            + File.separator + "drivers" + File.separator;

    public static String GECKO_DRIVER_PATH = driver_DIR + "geckodriver";
    public static String CHROME_DRIVER_PATH = driver_DIR + "chromedriver";


    public static String LMS_URL = "https://alchemy.hguy.co/lms";


    public static String USER_NAME = "root";
    public static String PASSWORD = "pa$$w0rd";


    public static String SCREENSHOTS_DIR = System.getProperty("user.dir")
            + File.separator
            + "screenshots"
            + File.separator;


    private static String modifyIfWindows(String inPath) {
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            return inPath + ".exe";
        } else {
            return inPath;
        }
    }
    public static WebDriver createFireFoxDriver() {
        //System.setProperty("webdriver.gecko.driver", modifyIfWindows(GECKO_DRIVER_PATH));
        return new FirefoxDriver();
    }
    public static WebDriver createChromeDriver() {
        return createChromeDriver(new ChromeOptions());
    }
    public static WebDriver createChromeDriver(ChromeOptions options) {
        //System.setProperty("webdriver.chrome.driver", modifyIfWindows(CHROME_DRIVER_PATH));
        return new ChromeDriver(options);
    }
}
