package tests;

import framework.browser.Browser;
import org.testng.annotations.*;
import framework.utils.MyLogger;

public class BaseTest {
    @BeforeMethod
    protected void setup() {
        MyLogger.logInfo("open Browser.");
    }

    @AfterMethod
    protected void quitDriver() {
        MyLogger.logInfo("close Browser.");
        Browser.quit();
    }
}