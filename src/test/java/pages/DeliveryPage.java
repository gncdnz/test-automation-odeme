package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by goncad on 29.11.2018.
 */
public class DeliveryPage extends AbstractPage {

    public DeliveryPage(WebDriver driver) {
        super(driver);
    }

    public void continueToPayment() {
        driver.findElement(By.className("proceed-container")).findElement(By.tagName("button")).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.className("payment-title"))
        );
    }

}
