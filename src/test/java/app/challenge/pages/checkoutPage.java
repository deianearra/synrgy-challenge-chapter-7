package app.challenge.pages;

import app.challenge.keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class checkoutPage {

    @FindBy(id = "shopping_cart_container")
    private static WebElement cart_icon;
    @FindBy(id = "checkout")
    private static WebElement checkout_button;
    @FindBy(id = "first-name")
    private static WebElement input_firstname;
    @FindBy(id = "last-name")
    private static WebElement input_lastname;
    @FindBy(id = "postal-code")
    private static WebElement input_postalcode;
    @FindBy(id = "continue")
    private static WebElement continue_button;
    @FindBy(id = "finish")
    private static WebElement finish_button;
    @FindBy(xpath = "//span[@class='title']")
    private static WebElement success_checkout;
    protected WebDriver webDriver;

    public checkoutPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    public static void doCheckout(String firstName, String lastName, String postalCode) {
        keyword.tapElement(cart_icon);
        keyword.tapElement(checkout_button);
        keyword.inputText(input_firstname, firstName);
        keyword.inputText(input_lastname, lastName);
        keyword.inputText(input_postalcode, postalCode);
        keyword.tapElement(continue_button);
        keyword.tapElement(finish_button);
    }

    public static void verifySuccessCheckout() {
        keyword.validate_element_is_visible_and_enabled(success_checkout);
    }
}