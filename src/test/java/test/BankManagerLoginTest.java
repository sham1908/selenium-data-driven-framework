package test;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import utils.excel.ExcelUtil;
import utils.logs.Log;

import java.io.IOException;
import java.lang.reflect.Method;

import static utils.ExtentReports.ExtentTestManager.startTest;

public class BankManagerLoginTest extends BaseTest {

    @BeforeTest
    public void setupTestData() throws IOException {
        //Set Test Data Excel and Sheet
        // Doing this in the test class because each test class may have different test data.
        Log.info("*****Setup Test Level Data*****");
        ExcelUtil.setExcelFileSheet("LoginData");
        System.out.println(ExcelUtil.getCellData(2, 0));
    }


    @Test
    public void addCustomer(Method method) {
        startTest(method.getName(), "Click on the Bank Manager Login Button");

        HomePage homePage = new HomePage(driver);

        homePage.goToWay2Automation()
                .goToBankManagerLoginPage()
                .addNewCustomer(
                        ExcelUtil.getCellData(2, 0),
                        ExcelUtil.getCellData(2, 1),
                        ExcelUtil.getCellData(2, 2)
                );
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
    }
}


