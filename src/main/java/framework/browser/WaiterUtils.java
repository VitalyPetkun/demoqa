package framework.browser;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import framework.utils.ConfigManager;
import java.time.Duration;

public class WaiterUtils {
    public static WebElement elementToBeClickable(By locator) {
        return new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(ConfigManager.getConfigInt("waitingTime")))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static Alert isAlertPresent() {
        return new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(ConfigManager.getConfigInt("waitingTime")))
                .until(ExpectedConditions.alertIsPresent());
    }

    public static boolean numberOfWindowsToBe() {
        return new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(ConfigManager.getConfigInt("waitingTime")))
                .until(ExpectedConditions.numberOfWindowsToBe(ConfigManager.getConfigInt("expectedNumberOfWindows")));
    }

    public static boolean invisibilityOfElementLocated(By locator) {
        return new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(ConfigManager.getConfigInt("waitingTime")))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
