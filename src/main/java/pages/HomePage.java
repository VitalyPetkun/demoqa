package pages;

import elements.Button;
import elements.WebTable;
import framework.BaseForm;
import org.openqa.selenium.By;

public class HomePage extends BaseForm {
    private final By XPATH_BTN_ALERTS_WINDOWS =
            By.xpath(".//*[@fill-rule='evenodd']//ancestor::div[contains(@class,'top-card')]//div[@class='card-body']");
    private final By XPATH_BTN_ELEMENTS =
            By.xpath(".//*[@version]//ancestor::div[contains(@class,'top-card')]//preceding-sibling::div[contains(@class,'top-card')]//div[@class='card-body']");
    private final By XPATH_BTN_WIDGETS = By.xpath(".//*[text()='Widgets']");

    public HomePage() {
        super(new WebTable(By.xpath("//div[@class='category-cards']"),"uniqElementHomePage"), "Home Page");
    }

    public void clickBtnAlertsFrameAndWindowsHome() {
        new Button(XPATH_BTN_ALERTS_WINDOWS,"btnAlertsWindows").click();
    }

    public void clickBtnElements() {
        new Button(XPATH_BTN_ELEMENTS,"btnElements").click();
    }

    public void clickBtnWidgets() {
        new Button(XPATH_BTN_WIDGETS,"btnWidgets").click();
    }

    public HeaderMenu getHeaderMenu() {
        return new HeaderMenu();
    }
}
