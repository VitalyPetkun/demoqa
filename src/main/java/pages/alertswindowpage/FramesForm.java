package pages.alertswindowpage;

import elements.WebTable;
import framework.browser.Browser;
import elements.Iframe;
import elements.TextBox;
import framework.BaseForm;
import org.openqa.selenium.By;

public class FramesForm extends BaseForm {
    private final By XPATH_TOP_IFRAME = By.xpath("//iframe[@id='frame1']");
    private final By XPATH_BOTTOM_IFRAME = By.xpath("//iframe[@id='frame2']");
    private final By XPATH_TXT_TOP_FRAME = By.xpath("//body");
    private final By XPATH_TXT_BOTTOM_FRAME = By.xpath("//body");

    public FramesForm() {
        super(new WebTable(By.xpath("//div[@id='framesWrapper']"),"uniqElementFramesForm"), "FramesForm");
    }

    public String getTextTopFrame() {
        new Iframe(XPATH_TOP_IFRAME, "topFrame").switchToFrame();
        return new TextBox(XPATH_TXT_TOP_FRAME, "txtTopFrame").getText();
    }

    public String getTextBottomFrame() {
        Browser.getDriver().switchTo().defaultContent();
        new Iframe(XPATH_BOTTOM_IFRAME, "bottomFrame").switchToFrame();
        return new TextBox(XPATH_TXT_BOTTOM_FRAME, "txtBottomFrame").getText();
    }
}
