package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by goncad on 30.11.2018.
 */
public class DriverFactory {

    public static WebDriver getDriver() {
        String browser = System.getProperty("browser");

        if (browser != null) {
            switch (browser) {
                case "firefox":
                    return getFirefoxDriver();
                case "chrome":
                    return getChromeDriver();
                default:
                    return getFirefoxDriver();
            }
        } else {
            return getFirefoxDriver();
        }
    }

    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
