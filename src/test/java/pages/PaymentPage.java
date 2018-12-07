package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by goncad on 29.11.2018.
 */
public class PaymentPage extends AbstractPage {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void goToOrderSummeryWithTransfer() {
        driver.findElement(By.className("paymentType-2")).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.presenceOfElementLocated(By.className("money-order-banks"))
        );
        waitForJavascriptEventBindings();
        driver.findElements(By.cssSelector(".money-order-banks .list-item")).get(0).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(By.className("proceed-container"))
        );
        driver.findElement(By.className("proceed-container")).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.titleIs("Sipariş Özeti")
        );
    }

    private void waitForJavascriptEventBindings() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
