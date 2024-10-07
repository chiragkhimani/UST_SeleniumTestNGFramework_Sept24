package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCartLink;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    List<WebElement> addToCartBtnList;

    @FindBy(id = "react-burger-menu-btn")
    WebElement hamBurgerMenu;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;

    public boolean isHomePageDisplayed() {
        return shoppingCartLink.isDisplayed();
    }

    public void clickOnAddToCartOfFirstItem() {
        addToCartBtnList.get(0).click();
    }

    public void clickOnShoppingCartLink() {
        shoppingCartLink.click();
    }

    public String getCartIconQty() {
        return shoppingCartLink.findElement(By.xpath("./span")).getText();
    }

    public void clickOnHamburgerMenu() {
        hamBurgerMenu.click();
    }

    public void clickOnLogoutLink() {
        logoutLink.click();
    }
}
