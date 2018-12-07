package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

/**
 * Created by goncad on 28.11.2018.
 */
public class HomePage extends AbstractPage{


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String keyword) {
        driver.findElement(By.id("productSearch")).sendKeys(keyword);
        driver.findElement(By.id("buttonProductSearch")).click();
    }

    public boolean isAnyItemFoundFor(String keyword) {
        String resultKeyword = driver.findElement(By.id("productresults")).findElement(By.className("search-results-title")).getText();
        resultKeyword = resultKeyword.substring(1, (resultKeyword.length()-1));
        boolean itemFound = driver.findElement(By.id("productresults")).findElement(By.className("totalItems")).getText().contains("bulundu");
        if((resultKeyword.equals(keyword)) && itemFound) {
            return true;
        }
        return false;
    }

    public void addToCart() {
        WebElement firstItemAddBtn = driver.findElements(By.className("add-to-basket")).get(0);
        firstItemAddBtn.click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("notification")));
    }

    public boolean isItemAddedToCart() {
        String cartCountText = driver.findElement(By.id("cartItemCount")).findElement(By.tagName("label")).getText();
        int cartCount = Integer.parseInt(cartCountText);
        return cartCount > 0;
    }

    public void goToCart() {
        driver.findElement(By.id("shoppingCart")).sendKeys(Keys.ENTER);
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.className("cart-title"))
        );
    }
}
