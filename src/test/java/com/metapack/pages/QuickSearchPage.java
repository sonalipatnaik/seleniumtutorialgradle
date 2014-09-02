package com.metapack.pages;

import org.openqa.selenium.WebDriver;

/**
 * Quick Search Page object which represents the Quick Search page in DM.
 *
 * @author rahulsingh
 *
 */
public class QuickSearchPage extends BasePage {

    public static final String SEARCH_BUTTON_CSS_SELECTOR = "input[type='submit'][class='button'][value='Search']";

    /**
     * Quick Search Page constructor taking the Web Driver as
     * an argument.
     *
     * @param driver WebDriver instance
     */
    public QuickSearchPage(WebDriver driver) {
        super(driver);
    }
}
