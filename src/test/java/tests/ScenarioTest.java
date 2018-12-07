package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.*;
import utils.AbstractTest;

/**
 * Created by goncad on 28.11.2018.
 */
public class ScenarioTest extends AbstractTest {

    @Test
    public void paymentWithTransfer() {
        successLogin();
        searchProductAndAddToCart();
        passToCart();
        passFromCartToCheckout();
        passFromCheckoutToPayment();
        passFromPaymentToOrderSummary();
        completeOrder();
    }

    @Test
    public void failedLogin() {
        login("abc", "abs");
    }

    public void successLogin() {
        login(configuration.getProperty("login.email"),
                configuration.getProperty("login.password"));
    }

    public void login(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(configuration.getProperty("login.url"));
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.isLoginSuccessfull());
        Assert.assertEquals(configuration.getProperty("homePage.url"), loginPage.getCurrentUrl());
    }

    public void searchProductAndAddToCart() {
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct(configuration.getProperty("search.key"));
        Assert.assertTrue(homePage.isAnyItemFoundFor(configuration.getProperty("search.key")));
        Assert.assertTrue(homePage.getCurrentUrl().contains(configuration.getProperty("search.key")));

        homePage.addToCart();
        Assert.assertTrue(homePage.isItemAddedToCart());
    }

    public void passToCart() {
        HomePage homePage = new HomePage(driver);
        homePage.goToCart();
        Assert.assertEquals(configuration.getProperty("cart.url"), homePage.getCurrentUrl());
    }

    public void passFromCartToCheckout() {
        CartPage cartPage = new CartPage(driver);
        cartPage.continueCheckout();
        Assert.assertEquals(configuration.getProperty("delivery.url"), cartPage.getCurrentUrl());
    }

    public void passFromCheckoutToPayment() {
        DeliveryPage deliveryPage = new DeliveryPage(driver);
        deliveryPage.continueToPayment();
        Assert.assertEquals(configuration.getProperty("payment.url"), deliveryPage.getCurrentUrl());
    }

    public void passFromPaymentToOrderSummary() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.goToOrderSummeryWithTransfer();
        Assert.assertEquals(configuration.getProperty("order.summary.url"), paymentPage.getCurrentUrl());
    }

    public void completeOrder() {
        OrderSummaryPage orderSummaryPage = new OrderSummaryPage(driver);
        orderSummaryPage.confirmOrder();
        Assert.assertEquals(configuration.getProperty("payment.success.url"), orderSummaryPage.getCurrentUrl());
        Assert.assertTrue(orderSummaryPage.isOrderSuccessfull());
    }

}
