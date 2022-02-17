package tests;

import framework.browser.Browser;
import framework.utils.ConfigManager;
import framework.utils.MyLogger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.widgetspage.WidgetsPage;
import utils.DateUtils;

public class DatePickerTest extends BaseTest{
    private HomePage homePage;
    private WidgetsPage widgetsPage;

    @Test
    public void checkDatePicker() {
        MyLogger.logInfo("start DatePickerTest.");

        homePage = new HomePage();
        widgetsPage = new WidgetsPage();

        Browser.openUrl(ConfigManager.getConfigString("URLHomePage"));

        homePage.getHeaderMenu().clickLinkHome();
        Assert.assertTrue(homePage.isFormOpen(),  "Didn't go to the Home page.");

        homePage.clickBtnWidgets();
        widgetsPage.clickBtnDatePicker();
        Assert.assertTrue(widgetsPage.getDatePickerForm().isFormOpen(), "A page with a Date Picker form is not open.");
        Assert.assertEquals(widgetsPage.getDatePickerForm().getTxtSelectDate(), DateUtils.getDateForTextBoxSelectDate(),
                "The values in the Select Date field do not match the current date.");
        Assert.assertEquals(widgetsPage.getDatePickerForm().getTxtDateAndTime(), DateUtils.getDateForTextBoxDateAndTime(),
                "The Date And Time field does not match the current date and time.");

        widgetsPage.getDatePickerForm().clickSelectDate();
        widgetsPage.getDatePickerForm().clickPopMenuYear();
        widgetsPage.getDatePickerForm().setYearInDatePicker(DateUtils.getNearestLeapYear());
        widgetsPage.getDatePickerForm().clickPopMenuMonth();
        widgetsPage.getDatePickerForm().setMonthInDatePicker(ConfigManager.getTestDataString("setMonthInDatePicker"));
        widgetsPage.getDatePickerForm().setDayInDatePicker(ConfigManager.getTestDataString("setMonthInDatePicker"),
                ConfigManager.getTestDataString("setDayInDatePicker"));

        Assert.assertEquals(widgetsPage.getDatePickerForm().getTxtSelectDate(), DateUtils.getNearest_29_February_forTextBoxSelectDate(),
                "The value in the field does not match the specified one.");

        MyLogger.logInfo("finish DatePickerTest.");
    }
}
