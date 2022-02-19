package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.logs.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver; //not private because it's used outside TestBase class
    protected Properties config = new Properties(); //not prvate
    protected Properties OR = new Properties(); //not private because it's used outside TestBase class
    private FileInputStream fis;
    public WebDriverWait wait;

    @BeforeClass
    public void setUp() throws InterruptedException {

        Log.info("Tests are starting");

        System.setProperty("webdriver.chrome.driver", "/Users/evangelos/Downloads/chromedriver");
        driver = new ChromeDriver();
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        Log.info("Tests are ending");
        driver.close();

    }


}
