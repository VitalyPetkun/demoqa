package pages.widgetspage;

import elements.Button;
import elements.WebTable;
import framework.BaseForm;
import org.openqa.selenium.By;

public class WidgetsPage extends BaseForm {
    private final By XPATH_BTN_SLIDER = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-3']");
    private final By XPATH_BTN_PROGRESS_BAR = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-4']");
    private final By XPATH_BTN_DATE_PICKER = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-2']");


    public WidgetsPage() {
        super(new WebTable(By.xpath("//div[@class='left-pannel']"),"uniqElementWidgetsPage"), "WidgetsPage");
    }

    public void clickBtnSlider() {
        new Button(XPATH_BTN_SLIDER, "btnSlider").click();
    }

    public void clickBtnProgressBar() {
        new Button(XPATH_BTN_PROGRESS_BAR, "btnProgressBar").click();
    }

    public void clickBtnDatePicker() {
        new Button(XPATH_BTN_DATE_PICKER, "btnDatePicker").click();
    }

    public SliderForm getSliderForm() {
        return new SliderForm();
    }

    public ProgressBarForm getProgressBarForm() {
        return new ProgressBarForm();
    }

    public DatePickerForm getDatePickerForm() {
        return new DatePickerForm();
    }
}
