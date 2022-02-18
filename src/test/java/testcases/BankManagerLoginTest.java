package testcases;

import base.BaseTest;
import com.beust.jcommander.FuzzyMap;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

import java.lang.reflect.Method;

import static utils.ExtentReports.ExtentTestManager.startTest;

public class BankManagerLoginTest extends BaseTest {

    @Test
    public void errorLogin(Method method) {
        startTest(method.getName(), "Click on the Bank Manager Login Button");

        BasePage basepage = new BasePage(driver);

        System.out.println("Inside BankManagerLoginTest Test");
        basepage.click(By.cssSelector("button[ng-click='manager()']"));
        //basepage.isElementPresent(By.cssSelector(OR.getProperty("addCustomerButton")));
        //Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustomerButton"))));

    }
}


