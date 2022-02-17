package tests;

import framework.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.widgetspage.WidgetsPage;
import framework.utils.ConfigManager;
import framework.utils.MyLogger;

public class SliderAndProgressBarTest extends BaseTest {
    private HomePage homePage;
    private WidgetsPage widgetsPage;
    private int currentValueProgressBar;

    @Test
    public void checkSliderAndProgressBar() {
        MyLogger.logInfo("start SliderAndProgressBarTest.");

        homePage = new HomePage();
        widgetsPage = new WidgetsPage();

        Browser.openUrl(ConfigManager.getConfigString("URLHomePage"));

        homePage.getHeaderMenu().clickLinkHome();
        Assert.assertTrue(homePage.isFormOpen(), "Didn't go to the Home page.");

        homePage.clickBtnWidgets();
        widgetsPage.clickBtnSlider();
        Assert.assertTrue(widgetsPage.getSliderForm().isFormOpen(), "A page with a Slider form is not open.");

        widgetsPage.getSliderForm().setValueSlider(ConfigManager.getTestDataInt("numberForSlider"));
        Assert.assertEquals(widgetsPage.getSliderForm().getValueSlider(), ConfigManager.getTestDataInt("numberForSlider"),
                "The value next to the slider does not match the randomly generated one.");

        widgetsPage.clickBtnProgressBar();
        Assert.assertTrue(widgetsPage.getProgressBarForm().isFormOpen(), "A page with a Progress Bar form is not open.");

        widgetsPage.getProgressBarForm().clickBtnStart();
        currentValueProgressBar = widgetsPage.getProgressBarForm().getCurrentValue();
        while (ConfigManager.getTestDataInt("ageEngineer") != currentValueProgressBar)
            currentValueProgressBar = widgetsPage.getProgressBarForm().getCurrentValue();
        widgetsPage.getProgressBarForm().clickBtnStop();
        Assert.assertEquals(widgetsPage.getProgressBarForm().getCurrentValue(), ConfigManager.getTestDataInt("ageEngineer"),
                "The value on the load bar does not match the age of the engineer.");

        MyLogger.logInfo("finish SliderAndProgressBarTest.");
    }
}
