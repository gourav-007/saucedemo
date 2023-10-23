package saucedemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import saucedemo.init.Base;

public class LoginPage extends Base {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private String title = "Swag Labs";
    private String errorNotificationUsername = "Epic sadface: Username is required";
    private String errorNotificationPassword = "Epic sadface: Password is required";
    private String strUsernameAndPassDoNotMatch = "Epic sadface: Username and password do not match any user in this service";

    private final By fieldUsername = By.xpath("//input[@id='user-name']");
    private final By fieldPassword = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//input[@class='submit-button btn_action']");
    private final By userNameIsRequired = By.xpath("//h3[text()='Epic sadface: Username is required']");
    private final By passIsRequired = By.xpath("//h3[text()='Epic sadface: Password is required']");
    private final By errorNotificationUsernameAndPassword = By.xpath("//h3[@data-test='error']");

    @Step("Fill \"Username\" field with data ({login}), fill \"Password\" field with data ({password}) and click \"LOGIN\" button")
    public void login(String login, String password) {
        driver.findElement(fieldUsername).sendKeys(login);
        driver.findElement(fieldPassword).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getErrorNotificationUsername() {
        return errorNotificationUsername;
    }

    public String getErrorNotificationPassword() {
        return errorNotificationPassword;
    }

    public String notificationUsername() {
        WebElement strUserNameIsRequired = driver.findElement(userNameIsRequired);
        return strUserNameIsRequired.getText();
    }

    public String notificationUsernameAndPassword() {
        WebElement strNotificationUsernameAndPassword = driver.findElement(errorNotificationUsernameAndPassword);
        return strNotificationUsernameAndPassword.getText();
    }

    public String notificationPassword() {
        WebElement strNotificationPassword = driver.findElement(passIsRequired);
        return strNotificationPassword.getText();
    }

    public String getStrUsernameAndPassDoNotMatch() {
        return strUsernameAndPassDoNotMatch;
    }

    public Boolean loginButtonIsDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }
}