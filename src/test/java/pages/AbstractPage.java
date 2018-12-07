package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by goncad on 30.11.2018.
 */
public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
