package com.automation.test;

import com.automation.pages.*;
import com.automation.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    ReviewPage reviewPage = new ReviewPage();
    OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();

    @BeforeMethod
    public void setUp() {
        DriverManager.createDriver();
    }

    @AfterMethod
    public void cleanUp() {
        DriverManager.getDriver().quit();
    }

}
