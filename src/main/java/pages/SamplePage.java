package pages;

import elements.TextBox;
import framework.BaseForm;
import org.openqa.selenium.By;

public class SamplePage extends BaseForm {
    public SamplePage() {
        super(new TextBox(By.xpath("//h1[@id='sampleHeading']"),"uniqElementSamplePage"), "SamplePage");
    }
}
