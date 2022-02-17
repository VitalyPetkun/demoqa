package pages.elementspage;

import elements.Link;
import elements.WebTable;
import framework.BaseForm;
import org.openqa.selenium.By;

public class LinksForm extends BaseForm {
    private final By XPATH_LINK_HOME = By.xpath("//a[@id='simpleLink']");

    public LinksForm() {
        super(new WebTable(By.xpath("//div[@id='linkWrapper']"),"uniqElementLinksForm"), "LinksForm");
    }

    public void clickLinkHome() {
        new Link(XPATH_LINK_HOME, "linkHome").click();
    }
}
