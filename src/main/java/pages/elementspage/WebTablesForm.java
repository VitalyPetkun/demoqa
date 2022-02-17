package pages.elementspage;

import elements.Button;
import elements.WebTable;
import framework.BaseForm;
import org.openqa.selenium.By;
import usermodel.User;

import java.util.Arrays;

public class WebTablesForm extends BaseForm {
    private final By XPATH_BTN_ADD = By.xpath("//button[@id='addNewRecordButton']");
    private final By XPATH_LIST_ROWS_WEB_TABLE = By.xpath(
            "//div[contains(@class,'rt-tr') and (contains(@class,'-even') or contains(@class,'-odd')) and not(contains(@class,'-padRow'))]");

    public WebTablesForm() {
        super(new WebTable(By.xpath("//div[contains(@class,'ReactTable')]"),"uniqElementRegistrationForm"), "WebTablesForm");
    }

    public void clickBtnAdd() {
        new Button(XPATH_BTN_ADD, "btnAdd").click();
    }

    public void clickBtnDelete(User user) {
        new Button(By.xpath("//span[@id='delete-record-" + (getIndexUserInWebTable(user) + 1) + "']"),
                "btnDeleteUser" + (getIndexUserInWebTable(user) + 1)).click();
    }

    public int sizeWebTable() {
        return new WebTable(XPATH_LIST_ROWS_WEB_TABLE, "listRowsWebTable").sizeList();
    }

    public int getIndexUserInWebTable(User user) {
        String[] listUsers;
        String[] userInfo = new String[] {user.getFirstName(), user.getLastName(), user.getAge(),
                user.getEmail(), user.getSalary(), user.getDepartment()};
        int index = -1;

        WebTable listRows = new WebTable(XPATH_LIST_ROWS_WEB_TABLE,"listRowsWebTable");
        for (int i = 0; i < listRows.sizeList(); i++) {
            listUsers = listRows.getTextElementForListElements(i).split("\n");
            if(Arrays.equals(listUsers, userInfo))
                index = i;
        }
        return index;
    }

    public RegistrationForm getRegistrationForm() {
        return new RegistrationForm();
    }
}
