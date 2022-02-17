package tests;

import browser.MyAlert;
import framework.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.alertswindowpage.AlertsWindowsPage;
import pages.HomePage;
import framework.utils.ConfigManager;
import framework.utils.MyLogger;

public class AlertsTest extends BaseTest{
    private HomePage homePage;
    private AlertsWindowsPage alertsWindowsPage;

    @Parameters({"url"})
    @Test
    public void checkAlerts(@Optional("https://demoqa.com/") String url) {
        MyLogger.logInfo("start AlertsTest.");

        homePage = new HomePage();
        alertsWindowsPage = new AlertsWindowsPage();

        Browser.openUrl(url);

        homePage.getHeaderMenu().clickLinkHome();
        Assert.assertTrue(homePage.isFormOpen(),  "Didn't go to the Home page.");

        homePage.clickBtnAlertsFrameAndWindowsHome();
        alertsWindowsPage.clickBtnAlerts();
        Assert.assertTrue(alertsWindowsPage.getAlertsForm().isFormOpen(),  "Didn't go to the Alerts form.");

        alertsWindowsPage.getAlertsForm().clickBtnToSeeAlert();
        Assert.assertEquals(MyAlert.getTextAlert(),"You clicked a button",
                "Alert with the text 'You clicked a button' is not open");

        MyAlert.acceptAlert();
        Assert.assertTrue((!MyAlert.isAlertOpen()), "Alert did not close.");

        alertsWindowsPage.getAlertsForm().clickBtnConfirm();
        Assert.assertEquals(MyAlert.getTextAlert(), "Do you confirm action?",
                "Alert with the text 'Do you confirm action?' is not open");

        MyAlert.acceptAlert();
        Assert.assertTrue(!MyAlert.isAlertOpen(), "Alert did not close.");

        Assert.assertEquals(alertsWindowsPage.getAlertsForm().getTextBtnConfirm(), "You selected Ok",
                "The inscription 'You selected Ok' did not appear next to the button");

        alertsWindowsPage.getAlertsForm().clickBtnPromt();
        Assert.assertEquals(MyAlert.getTextAlert(), "Please enter your name",
                "Alert with the text 'Please enter your name' is not open");

        MyAlert.inputText(ConfigManager.getTestDataString("inputTextAlert"));
        MyAlert.acceptAlert();
        Assert.assertTrue(!MyAlert.isAlertOpen(), "Alert did not close.");
        Assert.assertEquals(alertsWindowsPage.getAlertsForm().getTextBtnPromt(), "This is AlertsTest",
                "The inscription 'You selected Ok' did not appear next to the button");

        MyLogger.logInfo("finish AlertsTest.");
    }
}
