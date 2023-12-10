package app.challenge.steps;

import app.challenge.driverManager;
import app.challenge.pages.checkoutPage;
import app.challenge.pages.homePage;
import app.challenge.pages.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class checkoutStep {
    @And("user click Add To Cart button on product")
    public void user_click_Add_To_Cart() {
        new homePage(driverManager.getInstance().getDriver());
        homePage.TapAddToCart();
    }
    @And("user do checkout")
    public void user_do_checkout() {
        new checkoutPage(driverManager.getInstance().getDriver());
        checkoutPage.doCheckout("Dei", "Septi", "15523");
    }
    @And("verify checkout successfully")
    public void verify_checkout_successfully() {
        new checkoutPage(driverManager.getInstance().getDriver());
        checkoutPage.verifySuccessCheckout();
    }
}
