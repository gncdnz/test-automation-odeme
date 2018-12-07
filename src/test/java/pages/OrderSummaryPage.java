package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by goncad on 29.11.2018.
 */
public class OrderSummaryPage extends AbstractPage {

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }


    public void confirmOrder() {
        driver.findElement(By.cssSelector("button.btn:nth-child(2)")).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.presenceOfElementLocated(By.className("order-result"))
        );
    }

    public boolean isOrderSuccessfull() {
        String orderResult = driver.findElements(By.className("box-header-title")).get(0).getText();
        return orderResult.equals("Siparişiniz Alındı");
    }
}
