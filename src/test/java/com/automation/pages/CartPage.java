package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    @FindBy(id = "checkout")
    WebElement checkOutBtn;

    public boolean isCartPageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(checkOutBtn));
        return checkOutBtn.isDisplayed();
    }

    public void clickOnCheckoutBtn() {
        checkOutBtn.click();
    }
}
