package app.challenge.pages;

import app.challenge.keyword;import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class homePage {

    protected WebDriver webDriver;

    public homePage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(id = "shopping_cart_container")
    private static WebElement cart_icon;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private static WebElement add_to_cart_jacket;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private static WebElement add_to_cart_bike_light;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private static WebElement badge_cart;



    @FindBy(xpath = "//select[@class='product_sort_container']")
    private static WebElement select_filter;

    public static void comparePrice(WebDriver driver) {
        List<WebElement> itemPrices = driver.findElements(By.className("inventory_item_price"));
        boolean isSorted = isPriceSorted(itemPrices);

        Assert.assertTrue(isSorted, "Items are not sorted by price (high to low)");
    }
    private static boolean isPriceSorted(List<WebElement> itemPrices) {
        for (int i = 0; i < itemPrices.size() - 1; i++) {
            double value1 = extractNumericValue(itemPrices.get(i));
            double value2 = extractNumericValue(itemPrices.get(i + 1));

            if (value1 < value2) {
                return false;
            }
        }
        return true;
    }

    private static double extractNumericValue(WebElement element) {
        String priceText = element.getText().replace("$", "");
        return Double.parseDouble(priceText);
    }

    public static void verifyCartIconExist(){
        keyword.validate_element_is_visible_and_enabled(cart_icon);
    }
    public static void TapAddToCart(){
        keyword.tapElement(add_to_cart_jacket);
        keyword.tapElement(add_to_cart_bike_light);
        keyword.validate_element_is_visible_and_enabled(badge_cart);
    }
    public static void selectFilter(String value){
        keyword.selectOption(select_filter, value);
    }


}
