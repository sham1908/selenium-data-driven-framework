package pages;

import org.apache.logging.log4j.core.util.JsonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.logs.Log;

public class HomePage extends BasePage {

    /**
     * Constructor
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    String baseURL = "https://www.way2automation.com/angularjs-protractor/banking/#/login";

    /**
     * Web Elements
     */
    By bankManagerLoginButton = By.cssSelector("button[ng-click='manager()']");


    /**
     * Page Methods
     */

    //Go to Homepage: www.way2automation.com
    public HomePage goToWay2Automation() {
        Log.info("Opening N11 Website.");
        driver.get(baseURL);
        return this;
    }

    //Go to BankManagerLogin
    public BankManagerLoginPage goToBankManagerLoginPage() {
        Log.info("Going to Login Page..");
        click(bankManagerLoginButton);
        return new BankManagerLoginPage(driver);
    }

}
