package framework;

import framework.browser.Browser;
import framework.browser.WaiterUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import framework.utils.MyLogger;

import java.util.List;

public abstract class BaseElement{
    private By locator;
    private String elementName;

    protected BaseElement(By locator, String elementName) {
        this.locator = locator;
        this.elementName = elementName;
    }

    protected WebElement findElement() {
        return Browser.getDriver().findElement(locator);
    }

    protected List<WebElement> findElements() {
        return Browser.getDriver().findElements(locator);
    }

    public void click() {
        try {
            MyLogger.logInfo("click " + elementName + ".");
            WebElement element = WaiterUtils.elementToBeClickable(locator);
            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
        } catch (Exception ex) {
            MyLogger.logError("not click " + elementName + ".");
        }
    }

    public String getText() {
        return this.findElement().getText();
    }

    public boolean isPresent() {
        return this.findElements().size() > 0;
    }

    public int sizeList() {
        return this.findElements().size();
    }

    public String getTextElementForListElements(int index) {
        return this.findElements().get(index).getText();
    }

    public By getLocator() {
        return locator;
    }

    public String getElementName() {
        return elementName;
    }
}
