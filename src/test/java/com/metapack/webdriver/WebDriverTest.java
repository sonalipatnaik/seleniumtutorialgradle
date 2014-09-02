package com.metapack.webdriver;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.metapack.pages.LoginPage;

/**
 * Web Driver Selenium Test with Gradle.
 * 
 * @author rahulsingh
 * 
 */
public class WebDriverTest {
    private static final String URL = "http://dmtstbau/dm";
    private WebDriver driver;

    /**
     * Automated Selenium Web Driver Test.
     */
    @Test
    public void testWebDriver() {
        setDriver();
        driver.navigate().to(URL);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoginButtonToBeVisible();
        loginPage.enterTextInFieldById(LoginPage.USERID_FIELD_ID, "test999");
        loginPage.enterTextInFieldById(LoginPage.PASSWORD_FIELD_ID, "Mosal123");
        loginPage.iClickOnLoginButton();

        loginPage.iLogOut();
    }
    
    @After
    public void shutdownBroswer() {
        driver.quit();
    }

    private void setDriver() {
        DesiredCapabilities capability = null;
        System.out.println("Setting the FF driver");
        capability = DesiredCapabilities.firefox();
        capability.setBrowserName("firefox");
        capability.setPlatform(org.openqa.selenium.Platform.ANY);
        FirefoxProfile firefoxProfile = setFirefoxProfile("C:\\Users\\rsingh\\Downloads");
        driver = new FirefoxDriver(new FirefoxBinary(), firefoxProfile, capability);
        driver.manage().window().maximize();
    }

    /**
     * Sets the FirefoxProfile for the FF WebDriver. Used for the file label download so these settings are critical.
     * 
     * @param userDownloadDir
     *            user download directory
     * @return FirefoxProfile firefoxProfile
     */
    public FirefoxProfile setFirefoxProfile(String userDownloadDir) {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setAcceptUntrustedCertificates(true);
        firefoxProfile.setAcceptUntrustedCertificates(false);
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.dir", userDownloadDir);
        firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
        firefoxProfile.setPreference("browser.download.panel.firstSessionCompleted", true);

        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/pdf,application/x-pdf,application/csv,application/octet-stream,application/msexcel,text/comma-separated-values,"
                        + "application/vnd.ms-excel");
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
        firefoxProfile.setPreference("browser.download.panel.shown", false);
        firefoxProfile.setPreference("browser.download.useToolkitUI", true);
        firefoxProfile.setPreference("plugin.disable_full_page_plugin_for_types", "text/csv,application/pdf,application/x-pdf,application/vnd.adobe.xfdf,"
                + "application/csv,application/octet-stream,application/msexcel,text/comma-separated-values,application/vnd.ms-excel");
        firefoxProfile.setPreference("pdfjs.disabled", true);

        return firefoxProfile;
    }
}
