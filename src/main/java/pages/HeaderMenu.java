package pages;

import elements.Link;
import org.openqa.selenium.By;

public class HeaderMenu {
    private final By XPATH_LINK_HOME = By.xpath("//header/a");

    public void clickLinkHome() {
        new Link(XPATH_LINK_HOME, "linkHome").click();
    }
}
