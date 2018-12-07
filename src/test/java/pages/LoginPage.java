package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by goncad on 28.11.2018.
 */
public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void login(String email, String password) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("btn-login-submit")).click();
    }

    public boolean isLoginSuccessfull() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Hesabım")));
        return driver.findElement(By.partialLinkText("Hesabım")).isDisplayed();
    }

}
