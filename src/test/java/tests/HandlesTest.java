package tests;

import framework.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.alertswindowpage.AlertsWindowsPage;
import pages.elementspage.ElementsPage;
import pages.HomePage;
import pages.SamplePage;
import framework.utils.ConfigManager;
import framework.utils.MyLogger;

public class HandlesTest extends BaseTest{
    private HomePage homePage;
    private AlertsWindowsPage alertsWindowsPage;
    private String originalWindow;
    private SamplePage samplePage;
    private ElementsPage elementsPage;

    @Test
    public void checkHandles() {
        MyLogger.logInfo("start HandlesTest.");

        homePage = new HomePage();
        alertsWindowsPage = new AlertsWindowsPage();
        samplePage = new SamplePage();
        elementsPage = new ElementsPage();

        Browser.openUrl(ConfigManager.getConfigString("URLHomePage"));

        homePage.getHeaderMenu().clickLinkHome();
        Assert.assertTrue(homePage.isFormOpen(),  "Didn't go to the Home page.");

        homePage.clickBtnAlertsFrameAndWindowsHome();
        alertsWindowsPage.clickBtnBrowserWindows();
        Assert.assertTrue(alertsWindowsPage.getBrowserWindowsForm().isFormOpen(),
                "The page with the Browser Windows form is not open.");

        originalWindow = Browser.getWindowHandle();
        alertsWindowsPage.getBrowserWindowsForm().clickBtnNewTab();
        Browser.switchToNextWindow(originalWindow);
        Assert.assertTrue(samplePage.isFormOpen(),
                "New tab /sample not open with SamplePage.");

        Browser.closeWindow();
        Browser.switchToWindow(originalWindow);
        Assert.assertTrue(alertsWindowsPage.getBrowserWindowsForm().isFormOpen(),
                "The page with the Browser Windows form is not open.");

        alertsWindowsPage.getBrowserWindowsForm().clickWebTableElements();
        alertsWindowsPage.getBrowserWindowsForm().clickBtnLinks();
        Assert.assertTrue(elementsPage.getLinksForm().isFormOpen(),  "A page with a Links form is not open.");

        originalWindow = Browser.getWindowHandle();
        elementsPage.getLinksForm().clickLinkHome();
        Browser.switchToNextWindow(originalWindow);
        Assert.assertTrue(homePage.isFormOpen(),  "Didn't go to the Home page.");

        Browser.switchToWindow(originalWindow);
        Assert.assertTrue(elementsPage.getLinksForm().isFormOpen(),  "A page with a Links form is not open.");

        MyLogger.logInfo("finish HandlesTest.");
    }
}
