package pages.alertswindowpage;

import elements.Iframe;
import elements.TextBox;
import elements.WebTable;
import framework.BaseForm;
import org.openqa.selenium.By;

public class NestedFramesForm extends BaseForm {
    private final By XPATH_PARENT_IFRAME = By.xpath("//iframe[@id='frame1']");
    private final By XPATH_CHILD_IFRAME = By.xpath("//iframe");
    private final By XPATH_TXT_PARENT_FRAME = By.xpath("//body");
    private final By XPATH_TXT_CHILD_FRAME = By.xpath("//body");

    public NestedFramesForm() {
        super(new WebTable(By.xpath("//div[@id='framesWrapper']"),"uniqElementNestedFramesForm"), "NestedFramesForm");
    }

    public String getTextParentFrame() {
        new Iframe(XPATH_PARENT_IFRAME, "ParentFrame").switchToFrame();
        return new TextBox(XPATH_TXT_PARENT_FRAME, "txtParentFrame").getText();
    }

    public String getTextChildFrame() {
        new Iframe(XPATH_CHILD_IFRAME, "ChildFrame").switchToFrame();
        return new TextBox(XPATH_TXT_CHILD_FRAME, "txtParentFrame").getText();
    }
}
