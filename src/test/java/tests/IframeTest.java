package tests;

import framework.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.alertswindowpage.AlertsWindowsPage;
import pages.HomePage;
import framework.utils.ConfigManager;
import framework.utils.MyLogger;

public class IframeTest extends BaseTest{
    private HomePage homePage;
    private AlertsWindowsPage alertsWindowsPage;

    @Test
    public void checkIframe() {
        MyLogger.logInfo("start IframeTest.");

        homePage = new HomePage();
        alertsWindowsPage = new AlertsWindowsPage();

        Browser.openUrl(ConfigManager.getConfigString("URLHomePage"));

        homePage.getHeaderMenu().clickLinkHome();
        Assert.assertTrue(homePage.isFormOpen(),"Didn't go to the Home page.");

        homePage.clickBtnAlertsFrameAndWindowsHome();
        alertsWindowsPage.clickBtnNestedFrames();
        Assert.assertTrue(alertsWindowsPage.getNestedFramesForm().isFormOpen(),
                "The page with the form of Nested Frames is not open.");
        Assert.assertEquals(alertsWindowsPage.getNestedFramesForm().getTextParentFrame(), "Parent frame",
                "In the center of the page there is an inscription 'Parent frame'.");
        Assert.assertEquals(alertsWindowsPage.getNestedFramesForm().getTextChildFrame(), "Child Iframe",
                "In the center of the page there is an inscription 'Child Iframe'.");

        Browser.getDriver().switchTo().defaultContent();
        alertsWindowsPage.clickBtnFrames();
        Assert.assertTrue(alertsWindowsPage.getFramesForm().isFormOpen(),
                "The page with the form of Frames is not open.");
        Assert.assertEquals(alertsWindowsPage.getFramesForm().getTextTopFrame(), alertsWindowsPage.getFramesForm().getTextBottomFrame(),
                "The text from the top frame does not match the text from the bottom.");
        Browser.getDriver().switchTo().defaultContent();

        MyLogger.logInfo("finish IframeTest.");
    }
}
