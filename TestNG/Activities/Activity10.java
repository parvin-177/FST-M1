package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activity10 {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void beforeClass() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");

        // Open browser
        driver.get("https://www.training-support.net/selenium/simple-form");
    }
    public static ArrayList<ArrayList<String>> ReadExel(String excelFile){
        boolean debug=true;
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        File myFile = new File(excelFile);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(myFile);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Finds the workbook instance for XLSX file
        XSSFWorkbook myWorkBook = null;
        try {
            myWorkBook = new XSSFWorkbook (fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return first sheet from the XLSX workbook
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);

        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = mySheet.iterator();

        // Traversing over each row of XLSX file
        int count=1;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            ArrayList<String> InnerArray = new ArrayList<String>() ;
            //if(debug)System.out.print(count + ". \t");
            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case STRING:
                        String c = cell.getStringCellValue();
                        //if(debug)System.out.print(c + "\t");
                        InnerArray.add(c);
                        break;
                    case NUMERIC:
                        int n = (int) cell.getNumericCellValue();
                        //if(debug)System.out.print(n + "\t");
                        InnerArray.add(String.valueOf(n));
                        break;
                    case BOOLEAN:
                        boolean b = cell.getBooleanCellValue();
                        //if(debug)System.out.print(b + "\t");
                        InnerArray.add(String.valueOf(b));
                        break;
                    default :
                }
            }

            //if(debug)System.out.println("");
            data.add(InnerArray);
            count++;
        }

        return data;
    }
    @DataProvider(name = "Registration")
    public static Object[][] signUpInfo() {
        String filePath = "C://Users//01979D744//Documents//FST2023//FST-Selenium-Java//src//test//resources//sample.xlsx";
        ArrayList<ArrayList<String>> data = ReadExel(filePath);
        return new Object[][]{
                {data.get(1).get(0), data.get(1).get(1), data.get(1).get(2), data.get(1).get(3)},
                {data.get(2).get(0), data.get(2).get(1), data.get(2).get(2), data.get(2).get(3)},
                {data.get(3).get(0), data.get(3).get(1), data.get(3).get(2), data.get(3).get(3)},
        };
    }

    @Test(dataProvider = "Registration")
    public void registerTest(String firstName, String lastName, String email, String phoneNumber) {
        // Find the input fields and enter text
        WebElement firstNameField = driver.findElement(By.xpath("//input[@id = 'firstName']"));
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id = 'lastName']"));
        WebElement emailField = driver.findElement(By.xpath("//input[@id = 'email']"));
        WebElement phoneNumberField = driver.findElement(By.xpath("//input[@id = 'number']"));

        // Clear the fields
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        phoneNumberField.clear();

        // Enter the data in the fields
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        phoneNumberField.sendKeys(phoneNumber);

        // Click Submit
        driver.findElement(By.xpath("//input[contains(@class, 'green')]")).click();

        // Switch to alert
        //Alert message = driver.switchTo().alert();
        // Get alert message
        // System.out.println("Alert message: " + message.getText());
        //message.accept();

        // Refresh the page
        //driver.navigate().refresh();
        System.out.println("Registration is Successfully completed for all Users");
    }
         @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}