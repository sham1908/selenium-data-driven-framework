package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.logs.Log;

public class BankManagerLoginPage extends BasePage {

    /**
     * Constructor
     */
    public BankManagerLoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Web Elements
     */

    By addCustomerButton = By.cssSelector("button[ng-class='btnClass1']");
    By openAccountButton = By.cssSelector("button[ng-class='btnClass2']");
    By customersButton = By.cssSelector("button[ng-class='btnClass3']");
    By firstNameTextBox = By.cssSelector("input[placeholder='First Name'");
    By lastNameTextBox = By.cssSelector("input[placeholder='Last Name']");
    By postCodeTextBox = By.cssSelector("input[placeholder='Post Code']");
    By addCustomerConfirmButton = By.cssSelector("button[class='btn btn-default']");


    /**
     * Page Methods
     */
    //Create a customer
    public void addNewCustomer() {
        Log.info("Creating new customer");
        click(addCustomerButton);
        writeText(firstNameTextBox, "Evangelos");
        writeText(lastNameTextBox, "Evangelos");
        writeText(postCodeTextBox, "N4413");
        click(addCustomerConfirmButton);
    }
}
