package pages.alertswindowpage;

import elements.Button;
import elements.WebTable;
import framework.BaseForm;
import org.openqa.selenium.By;

public class BrowserWindowsForm extends BaseForm {
    private final By XPATH_BTN_NEW_TAB = By.xpath("//button[@id='tabButton']");
    private final By XPATH_BTN_LINKS = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-5']");
    private final By XPATH_WEB_TABLE_ELEMENTS = By.xpath("//div[@class='header-text' and text()='Elements']");

    public BrowserWindowsForm() {
        super(new WebTable(By.xpath("//div[@id='browserWindows']"),"uniqElementBrowserWindowsForm"), "BrowserWindowsForm");
    }

    public void clickBtnNewTab() {
        new Button(XPATH_BTN_NEW_TAB, "btnNewTab").click();
    }

    public void clickBtnLinks() {
        new Button(XPATH_BTN_LINKS, "btnLinks").click();
    }

    public void clickWebTableElements() {
        new WebTable(XPATH_WEB_TABLE_ELEMENTS, "webTableElements").click();
    }
}
