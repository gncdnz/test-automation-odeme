package utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by goncad on 28.11.2018.
 */
public class AbstractTest {

    protected static WebDriver driver;
    protected static Configuration configuration;

    @Rule
    public ScreenShotRule screenShotRule = new ScreenShotRule(driver);

    @BeforeClass
    public static void openBrowser() {
        driver = DriverFactory.getDriver();
        configuration = new Configuration();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }

}
