package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

/**
 * Created by goncad on 28.11.2018.
 */
public class CartPage extends AbstractPage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void continueCheckout() {
        driver.findElement(By.className("cart-proceed-container")).findElement(By.tagName("button")).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.className("shipment-group"))
        );
    }

}
