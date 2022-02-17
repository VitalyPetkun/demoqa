package pages.elementspage;

import elements.Button;
import elements.TextBox;
import elements.WebTable;
import framework.BaseForm;
import framework.utils.MyLogger;
import org.openqa.selenium.By;
import usermodel.User;

public class RegistrationForm extends BaseForm {
    private final By XPATH_BTN_SUBMIT = By.xpath("//button[@id='submit']");
    private final By XPATH_TXT_FIRST_NAME = By.xpath("//input[@id='firstName']");
    private final By XPATH_TXT_LAST_NAME = By.xpath("//input[@id='lastName']");
    private final By XPATH_TXT_EMAIL = By.xpath("//input[@id='userEmail']");
    private final By XPATH_TXT_AGE = By.xpath("//input[@id='age']");
    private final By XPATH_TXT_SALARY = By.xpath("//input[@id='salary']");
    private final By XPATH_TXT_DEPARTMENT = By.xpath("//input[@id='department']");

    public RegistrationForm() {
        super(new WebTable(By.xpath("//div[@class='modal-content']"),"uniqElementRegistrationForm"), "RegistrationForm");
    }

    public void clickBtnSubmit() {
        new Button(XPATH_BTN_SUBMIT, "btnSubmit").click();
    }

    public void inputInfoUser(User user) {
        MyLogger.logInfo("input info user.");
        inputFirstName(user.getFirstName());
        inputLastName(user.getLastName());
        inputEmail(user.getEmail());
        inputAge(user.getAge());
        inputSalary(user.getSalary());
        inputDepartment(user.getDepartment());
    }

    public void inputFirstName(String firstName) {
        new TextBox(XPATH_TXT_FIRST_NAME, "txtFirstName").inputText(firstName);
    }

    public void inputLastName(String lastName) {
        new TextBox(XPATH_TXT_LAST_NAME, "txtLastName").inputText(lastName);
    }

    public void inputEmail(String email) {
        new TextBox(XPATH_TXT_EMAIL, "txtEmail").inputText(email);
    }

    public void inputAge(String age) {
        new TextBox(XPATH_TXT_AGE, "txtAge").inputText(age);
    }

    public void inputSalary(String salary) {
        new TextBox(XPATH_TXT_SALARY, "txtSalary").inputText(salary);
    }

    public void inputDepartment(String department) {
        new TextBox(XPATH_TXT_DEPARTMENT, "txtDepartment").inputText(department);
    }
}
