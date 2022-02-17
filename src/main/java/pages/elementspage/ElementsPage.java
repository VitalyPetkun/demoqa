package pages.elementspage;

import elements.Button;
import elements.WebTable;
import framework.BaseForm;
import org.openqa.selenium.By;

public class ElementsPage extends BaseForm {
    private final By XPATH_BTN_WEB_TABLES = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-3']");

    public ElementsPage() {
        super(new WebTable(By.xpath("//div[@class='left-pannel']"),"uniqElementElementsPage"), "ElementsPage");
    }

    public void clickBtnWebTables() {
        new Button(XPATH_BTN_WEB_TABLES, "btnWebTables").click();
    }

    public WebTablesForm getWebTablesForm() {
        return new WebTablesForm();
    }

    public LinksForm getLinksForm() {
        return new LinksForm();
    }
}
