package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginLogoutTest extends BaseTest {

    @Test(dataProvider = "getValidCredentials")
    public void verifyUserCanLoginWithValidCred(String username, String password) {
        loginPage.openWebsite();
        loginPage.doLogin(username, password);
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @DataProvider
    public Object[][] getValidCredentials() {
        Object[][] credentials = {
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };

        return credentials;
    }

    @Test
    public void verifyApplicationSavesStateForUser() {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));
        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickOnAddToCartOfFirstItem();
        Assert.assertEquals(homePage.getCartIconQty(), "1");
        homePage.clickOnHamburgerMenu();
        homePage.clickOnLogoutLink();
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));
        Assert.assertTrue(homePage.isHomePageDisplayed());
        Assert.assertEquals(homePage.getCartIconQty(), "1");
    }

}
