package test;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import utils.excel.ExcelUtil;

import java.io.IOException;
import java.lang.reflect.Method;

import static utils.ExtentReports.ExtentTestManager.startTest;

public class BankManagerLoginTest extends BaseTest {

//    @BeforeTest
//    public void setupTestData() throws IOException {
//        //Set Test Data Excel and Sheet
//        System.out.println("************Setup Test Level Data**********");
//        ExcelUtil.setExcelFileSheet("LoginData");
//        System.out.println(ExcelUtil.getCellData(2, 0));
//    }


    @Test
    public void addCustomer(Method method) {
        startTest(method.getName(), "Click on the Bank Manager Login Button");

        HomePage homePage = new HomePage(driver);

        homePage.goToWay2Automation()
                .goToBankManagerLoginPage()
                .addNewCustomer();
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
    }
}


