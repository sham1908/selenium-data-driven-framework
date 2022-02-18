package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.logs.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

public class BaseTest {

    /*
    Webdriver - done
    Properties - done
    Logs
    ExtentReports
    DB
    Excel
    Mail
    */


    protected WebDriver driver; //not private because it's used outside TestBase class
    private Properties config = new Properties();
    protected Properties OR = new Properties(); //not private because it's used outside TestBase class
    private FileInputStream fis;
    public WebDriverWait wait;

    @BeforeSuite
    public void setUp() throws InterruptedException {

        Log.info("Tests are starting");

        //load the properties file
        if (driver == null) {
            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/Config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                config.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/Or.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                OR.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(config.getProperty("browser").equals(("chrome"))){
                driver = new ChromeDriver();
            }

            driver.get((config.getProperty("testUrl")));
            Thread.sleep(2000);
            driver.manage().window().maximize();
        }

    }

    @AfterSuite
    public void tearDown() {
        Log.info("Tests are ending");
        driver.close();

    }

    public boolean isElementPresent(By by){

        try{
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    //Wait
    public WebElement waitVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
