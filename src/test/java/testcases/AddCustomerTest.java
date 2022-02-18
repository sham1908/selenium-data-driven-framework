package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ExcelUtil;

import java.io.IOException;

public class AddCustomerTest extends BaseTest {

    @BeforeTest
    public void setupTestData() throws IOException {
        //Set Test Data Excel and Sheet
        System.out.println("************Setup Test Level Data**********");
        ExcelUtil.setExcelFileSheet("LoginData");
        System.out.println(ExcelUtil.getCellData(2, 0));
    }

    @Test(priority = 0, description= "Add Customer test")
    public void addCustomer() throws InterruptedException {

        System.out.println("Inside errorLogin Test");
        //System.out.println(OR.getProperty("bankManagerLoginButton"));
        driver.findElement(By.cssSelector(OR.getProperty("bankManagerLoginButton"))).click();
        //driver.findElement(By.cssSelector("button[ng-click='manager()']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(OR.getProperty("addCustomerButton"))).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(OR.getProperty("firstNameTextBox"))).sendKeys(ExcelUtil.getCellData(2, 0));
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(OR.getProperty("lastNameTextBox"))).sendKeys(ExcelUtil.getCellData(2, 1));
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(OR.getProperty("postCodeTextBox"))).sendKeys(ExcelUtil.getCellData(2, 2));
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(OR.getProperty("addCustomerConfirmButton"))).click();


    }
}
