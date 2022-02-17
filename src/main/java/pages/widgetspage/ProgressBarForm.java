package pages.widgetspage;

import elements.Button;
import elements.TextBox;
import elements.WebTable;
import framework.BaseForm;
import org.openqa.selenium.By;

public class ProgressBarForm extends BaseForm {
    private final By XPATH_BTN_START = By.xpath("//button[@id='startStopButton']");
    private final By XPATH_BTN_STOP = By.xpath("//button[@id='startStopButton']");
    private final By XPATH_TXT_CURRENT_VALUE = By.xpath("//div[@id='progressBar']/div");

    public ProgressBarForm() {
        super(new WebTable(By.xpath("//div[@id='progressBarContainer']"),"uniqElementProgressBarForm"), "ProgressBarForm");
    }

    public void clickBtnStart() {
        new Button(XPATH_BTN_START, "btnStart").click();
    }

    public void clickBtnStop() {
        new Button(XPATH_BTN_STOP, "btnStop").click();
    }

    public int getCurrentValue() {
        return Integer.valueOf(new TextBox(XPATH_TXT_CURRENT_VALUE, "txtCurrentValue").getTextAttribute("aria-valuenow"));
    }
}
