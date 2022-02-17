package pages.widgetspage;

import elements.*;
import framework.BaseForm;
import framework.utils.MyLogger;
import org.openqa.selenium.By;

public class DatePickerForm extends BaseForm {
    private final By XPATH_TEXT_BOX_SELECT_DATE = By.xpath("//input[@id='datePickerMonthYearInput']");
    private final By XPATH_TEXT_BOX_DATE_AND_TIME = By.xpath("//input[@id='dateAndTimePickerInput']");
    private final By XPATH_POP_MENU_MONTH = By.xpath("//select[@class='react-datepicker__month-select']");
    private final By XPATH_POP_MENU_YEAR = By.xpath("//select[@class='react-datepicker__year-select']");

    public DatePickerForm() {
        super(new WebTable(By.xpath("//div[@id='datePickerContainer']"),"uniqElementDatePickerForm"),"Date Picker Form");
    }

    public String getTxtSelectDate() {
        return new TextBox(XPATH_TEXT_BOX_SELECT_DATE, "TextBoxSelectDate").getTextAttribute("value");
    }

    public String getTxtDateAndTime() {
        return new TextBox(XPATH_TEXT_BOX_DATE_AND_TIME, "TextBoxDateAndTime").getTextAttribute("value");
    }

    public void clickSelectDate() {
        new DatePicker(XPATH_TEXT_BOX_SELECT_DATE, "DatePickerSelectDate").click();
    }

    public void clickPopMenuMonth() {
        new PopMenu(XPATH_POP_MENU_MONTH,"PopMenuMonth").click();
    }

    public void clickPopMenuYear() {
        new PopMenu(XPATH_POP_MENU_YEAR,"PopMenuYear").click();
    }

    public void setMonthInDatePicker(String month) {
        MyLogger.logInfo("set month in date picker - " + month + ".");
        new PopMenuItem(By.xpath("//option[text()='" + month + "']"), "PopMenuMonth " + month).click();
    }

    public void setYearInDatePicker(String year) {
        MyLogger.logInfo("set year in date picker - " + year + ".");
        new PopMenuItem(By.xpath("//option[text()='" + year + "']"),
                "PopMenuYear " + year).click();
    }

    public void setDayInDatePicker(String month, String day) {
        MyLogger.logInfo("set day in date picker - " + day + ".");
        new DatePicker(By.xpath("//div[contains(@class,'react-datepicker__day') and contains(@aria-label,'" + month + " " + day + "')]"),
                "DatePickerDate " + month + day).click();
    }
}
