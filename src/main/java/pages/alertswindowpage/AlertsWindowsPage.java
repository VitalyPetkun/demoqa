package pages.alertswindowpage;

import elements.Button;
import elements.WebTable;
import framework.BaseForm;
import org.openqa.selenium.By;

public class AlertsWindowsPage extends BaseForm {
    private final By XPATH_BTN_ALERTS = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-1']");
    private final By XPATH_BTN_NESTED_FRAMES = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-3']");
    private final By XPATH_BTN_FRAMES = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-2']");
    private final By XPATH_BTN_BROWSER_WINDOWS = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-0']");

    public AlertsWindowsPage() {
        super(new WebTable(By.xpath("//div[@class='left-pannel']"),"uniqElementAlertsWindowsPage"), "AlertsWindows Page");
    }

    public void clickBtnAlerts() {
        new Button(XPATH_BTN_ALERTS, "btnAlerts").click();
    }

    public void clickBtnNestedFrames() {
        new Button(XPATH_BTN_NESTED_FRAMES, "btnNestedFrames").click();
    }

    public void clickBtnFrames() {
        new Button(XPATH_BTN_FRAMES, "btnFrames").click();
    }

    public void clickBtnBrowserWindows() {
        new Button(XPATH_BTN_BROWSER_WINDOWS, "btnBrowserWindows").click();
    }

    public AlertsForm getAlertsForm() {
        return new AlertsForm();
    }

    public NestedFramesForm getNestedFramesForm() {
        return new NestedFramesForm();
    }

    public FramesForm getFramesForm() {
        return new FramesForm();
    }

    public BrowserWindowsForm getBrowserWindowsForm() {
        return new BrowserWindowsForm();
    }
}
