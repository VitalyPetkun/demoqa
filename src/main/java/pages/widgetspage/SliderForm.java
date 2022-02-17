package pages.widgetspage;

import elements.Slider;
import elements.TextBox;
import elements.WebTable;
import framework.BaseForm;
import framework.utils.MyLogger;
import org.openqa.selenium.By;

public class SliderForm extends BaseForm {
    private final By XPATH_SLIDER = By.xpath("//div[@id='sliderContainer']//input[contains(@class,'slider')]");
    private final By XPATH_TXT_VALUES_SLIDER = By.xpath("//div[@id='sliderContainer']//input[@id='sliderValue']");

    public SliderForm() {
        super(new WebTable(By.xpath("//div[@id='sliderContainer']"),"uniqElementSliderForm"), "SliderForm");
    }

    public void setValueSlider(int value) {
        MyLogger.logInfo("set value slider -" + String.valueOf(value) + ".");
        new Slider(XPATH_SLIDER, "slider").setSliderValue(getValueSlider(), value);
    }

    public int getValueSlider() {
        return Integer.valueOf(new TextBox(XPATH_TXT_VALUES_SLIDER, "txtValueSlider").getTextAttribute("value"));
    }
}
