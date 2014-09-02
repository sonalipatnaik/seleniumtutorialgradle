package com.metapack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page superclass providing page object functionality to all other Page objects.
 *
 * @author rahulsingh
 *
 */
public class BasePage {

    private static final String LOG_OUT_LINK = "Log out";
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor passing in a Web Driver instance.
     *
     * @param driver WebDriver instance
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 20);
    }

    /**
     * Get Element By CSS Selector.
     *
     * @param cssSelector CSS Selector to find the element
     * @return WebElement element found in the page
     */
    public WebElement getElementByCssSelector(String cssSelector) {
        WebElement element = getDriver().findElement(By.cssSelector(cssSelector));
        return element;
    }

    /**
     * Retrieve the element representation by it's id.
     *
     * @param elementId element id
     * @return WebElement instance
     */
    public WebElement getElementById(String elementId) {
        WebElement element = getDriver().findElement(By.id(elementId));
        return element;
    }

    /**
     * Log out of the DM application automated test.
     */
    public void iLogOut() {
        WebElement element = getDriver().findElement(By.linkText(LOG_OUT_LINK));
        element.click();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWebDriverWait() {
        return wait;
    }

    public void setWebDriverWait(WebDriverWait wait) {
        this.wait = wait;
    }
}
