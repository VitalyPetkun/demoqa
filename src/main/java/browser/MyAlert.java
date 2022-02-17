package browser;

import framework.browser.WaiterUtils;
import org.openqa.selenium.Alert;
import framework.utils.MyLogger;

public class MyAlert {
    public static String getTextAlert() {
        Alert element = WaiterUtils.isAlertPresent();
        return element.getText();
    }

    public static void acceptAlert() {
        try {
            MyLogger.logInfo("closing alert.");
            Alert element = WaiterUtils.isAlertPresent();
            element.accept();
        } catch (Exception ex) {
            MyLogger.logError("not close alert.");
        }
    }
    
    public static void inputText(String text) {
        MyLogger.logInfo("input text in Alert.");
        Alert element = WaiterUtils.isAlertPresent();
        element.sendKeys(text);
    }

    public static boolean isAlertOpen() {
        try {
            MyLogger.logInfo("open alert.");
            WaiterUtils.isAlertPresent();
            return true;
        } catch (Exception e) {
            MyLogger.logWarn("not open alert.");
        }
        return false;
    }
}
