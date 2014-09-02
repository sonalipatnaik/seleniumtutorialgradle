package com.metapack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Represents Login page as a Page Object.
 *
 * @author rahulsingh
 *
 */
public class LoginPage extends BasePage {

    public static final String USERID_FIELD_ID = "userId";
    public static final String PASSWORD_FIELD_ID = "password";
    private static final String LOGIN_BUTTON_ID = "loginButton";

    /**
     * Login Page constructor.
     *
     * @param driver Web Driver instance
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Click on the Login Button.
     */
    public void iClickOnLoginButton() {
        WebElement element = getElementById(LOGIN_BUTTON_ID);
        element.click();

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector(QuickSearchPage.SEARCH_BUTTON_CSS_SELECTOR)));
    }

    /**
     * Wait for the Login button to be visible.
     */
    public void waitForLoginButtonToBeVisible() {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.id(LOGIN_BUTTON_ID)));
    }

    /**
     * Enter text into the HTML Element field accessed by it's id.
     *
     * @param elementId element's id
     * @param text text to be entered into the Web Driver
     */
    public void enterTextInFieldById(String elementId, String text) {
        WebElement element = getElementById(elementId);
        element.sendKeys(text);
    }
}
