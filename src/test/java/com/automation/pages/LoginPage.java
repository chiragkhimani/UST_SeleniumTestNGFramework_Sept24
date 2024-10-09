package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    public void doLogin(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void openWebsite() {
        driver.get(ConfigReader.getConfigValue("application.url"));
        Allure.step("Website Opened!", Status.PASSED);
    }

    public boolean isLoginPageDisplayed() {
        return usernameInput.isDisplayed() && passwordInput.isDisplayed();
    }
}
