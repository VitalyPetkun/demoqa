package tests;

import framework.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.elementspage.ElementsPage;
import pages.HomePage;
import usermodel.User;
import framework.utils.ConfigManager;
import framework.utils.MyLogger;
import utils.UserManager;

public class TablesTest extends BaseTest {
    private HomePage homePage;
    private ElementsPage elementsPage;

    @DataProvider
    public Object[][] getUser() {
        return new Object[][]{
                {UserManager.getUser(0)},
                        {UserManager.getUser(1)}
        };
    }

    @Test(dataProvider = "getUser")
    public void checkTables(User user) {
        MyLogger.logInfo("start TablesTest.");

        homePage = new HomePage();
        elementsPage = new ElementsPage();
        int sizeWebTableAfterAddUser;

        Browser.openUrl(ConfigManager.getConfigString("URLHomePage"));

        homePage.getHeaderMenu().clickLinkHome();
        Assert.assertTrue(homePage.isFormOpen(),
                "Didn't go to the Home page.");

        homePage.clickBtnElements();
        elementsPage.clickBtnWebTables();
        Assert.assertTrue(elementsPage.getWebTablesForm().isFormOpen(), "A page with a Web Tables form is not open.");

        elementsPage.getWebTablesForm().clickBtnAdd();
        Assert.assertTrue(elementsPage.getWebTablesForm().getRegistrationForm().isFormOpen(),
                "The Registration Form did not appear on the page.");

        elementsPage.getWebTablesForm().getRegistrationForm().inputInfoUser(user);
        elementsPage.getWebTablesForm().getRegistrationForm().clickBtnSubmit();
        Assert.assertTrue(elementsPage.getWebTablesForm().getRegistrationForm().isFormClose(),
                "The Registration Form is not closed.");
        Assert.assertTrue(elementsPage.getWebTablesForm().getIndexUserInWebTable(user) >= 0,
                "User userNumber data did not appear in the table.");

        sizeWebTableAfterAddUser = elementsPage.getWebTablesForm().sizeWebTable();
        elementsPage.getWebTablesForm().clickBtnDelete(user);

        Assert.assertFalse(elementsPage.getWebTablesForm().getIndexUserInWebTable(user) >= 0,
                "User userNumber has not been removed from the table.");
        Assert.assertNotEquals(elementsPage.getWebTablesForm().sizeWebTable(), sizeWebTableAfterAddUser,
                "The number of records in the table has not changed.");

        MyLogger.logInfo("finish TablesTest.");
    }
}
