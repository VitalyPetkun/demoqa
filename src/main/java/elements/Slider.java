package elements;

import framework.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import framework.utils.MyLogger;

public class Slider extends BaseElement {
    public Slider(By locator, String elementName) {
        super(locator, elementName);
    }

    public void setSliderValue(int currentValue, int setValue) {
        MyLogger.logInfo("setValue " + this.getElementName() + " - " + setValue + ".");
        if(currentValue < setValue)
            for(int i = currentValue; i < setValue; i++)
                this.findElement().sendKeys(Keys.ARROW_RIGHT);
        if(currentValue > setValue)
            for(int i = currentValue; i > setValue; i--)
                this.findElement().sendKeys(Keys.ARROW_LEFT);
    }
}
