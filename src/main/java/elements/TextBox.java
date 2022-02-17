package elements;

import framework.BaseElement;
import framework.utils.MyLogger;
import org.openqa.selenium.By;

public class TextBox extends BaseElement {
    public TextBox(By locator, String elementName) {
        super(locator, elementName);
    }

    public void inputText(String text) {
        MyLogger.logInfo("input '" + text +"' in " + this.getElementName() + ".");
        this.findElement().sendKeys(text);
    }

    public String getTextAttribute(String attribute) {
        return this.findElement().getAttribute(attribute);
    }
}
