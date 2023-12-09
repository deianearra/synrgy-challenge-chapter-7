package app.challenge.pages;

import app.challenge.keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class homePage {

    protected WebDriver webDriver;

    public homePage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(id = "shopping_cart_container")
    private static WebElement cart_icon;

    public static void verifyCartIconExist(){
        keyword.validate_element_is_visible_and_enabled(cart_icon);
    }
}
