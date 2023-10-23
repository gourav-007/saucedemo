package saucedemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Finish {

    public WebDriver driver;

    public Finish(WebDriver driver) {
        this.driver = driver;
    }

    private final By gratitudeNotification = By.xpath("//h2[text()='Thank you for your order!']");

    @Step("Return notification with gratitude")
    public String getGratitudeNotification() {
        return driver.findElement(gratitudeNotification).getText();
    }
}