package elements;

import framework.BaseElement;
import framework.browser.Browser;
import framework.utils.MyLogger;
import org.openqa.selenium.By;

public class Iframe extends BaseElement {
    public Iframe(By locator, String elementName) {
        super(locator, elementName);
    }

    public void switchToFrame() {
        try {
            MyLogger.logInfo("switch to " + getElementName() + ".");
            Browser.getDriver().switchTo().frame(this.findElement());
        } catch (Exception ex) {
            MyLogger.logError("not switch to " + getElementName() + ".");
        }
    }
}
