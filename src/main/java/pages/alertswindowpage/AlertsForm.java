package pages.alertswindowpage;

import elements.Button;
import elements.TextBox;
import elements.WebTable;
import framework.BaseForm;
import org.openqa.selenium.By;

public class AlertsForm extends BaseForm {
    private final By XPATH_BTN_TO_SEE_ALERT = By.xpath("//button[@id='alertButton']");
    private final By XPATH_BTN_CONFIRM = By.xpath("//button[@id='confirmButton']");
    private final By XPATH_BTN_PROMT = By.xpath("//button[@id='promtButton']");
    private final By XPATH_TXT_BTN_CONFIRM = By.xpath("//span[@id='confirmResult']");
    private final By XPATH_TXT_BTN_PROMT = By.xpath("//span[@id='promptResult']");

    public AlertsForm() {
        super(new WebTable(By.xpath("//div[@id='javascriptAlertsWrapper']"),"uniqElementAlertForm"), "AlertsForm");
    }

    public void clickBtnToSeeAlert() {
        new Button(XPATH_BTN_TO_SEE_ALERT, "btnToSeeAlert").click();
    }

    public void clickBtnConfirm() {
        new Button(XPATH_BTN_CONFIRM, "btnConfirm").click();
    }

    public void clickBtnPromt() {
        new Button(XPATH_BTN_PROMT, "btnPromt").click();
    }

    public String getTextBtnConfirm() {
        return new TextBox(XPATH_TXT_BTN_CONFIRM, "textBoxBtnConfirm").getText();
    }

    public String getTextBtnPromt() {
        return new TextBox(XPATH_TXT_BTN_PROMT, "textBoxBtnConfirm").getText().replace("You entered ", "");
    }
}
