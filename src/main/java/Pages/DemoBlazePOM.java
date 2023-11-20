package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import UIElements.Button;

public class DemoBlazePOM {
    private WebDriver driver;
    private WebDriverWait wait;

    // Define locators for elements on the page
    private By laptopsCategoryLocator = By.cssSelector("a#itemc[onclick*='notebook']");
    private By phonesCategoryLocator = By.cssSelector("a#itemc[onclick*='phone']");
    private By cartLinkLocator = By.id("cartur");

    // Initialize UI element classes
    private Button laptopsCategoryButton;
    private Button phonesCategoryButton;

    public DemoBlazePOM(WebDriver driver) {
        this.driver = driver;

        // Initialize the WebDriverWait with a 10-second timeout
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Initialize UI element classes
        laptopsCategoryButton = new Button(driver, laptopsCategoryLocator);
        phonesCategoryButton = new Button(driver, phonesCategoryLocator);
    }

    // Methods to interact with the page
    public void navigateToHomePage() {
        String url = "https://www.demoblaze.com/index.html";
        driver.get(url);
    }

    public void chooseLaptopsCategory() {
        laptopsCategoryButton.click();
    }

    public void choosePhonesCategory() {
        phonesCategoryButton.click();
    }

    public void addToCart() {
        By addToCartButtonLocator = By.xpath("//a[contains(@onclick, 'addToCart') and contains(@class, 'btn-success')]");
        Button addToCartButton = new Button(driver, addToCartButtonLocator);
        addToCartButton.click();
    }

    public void viewCart() {
        Button cartLinkButton = new Button(driver, cartLinkLocator);
        cartLinkButton.click();
    }

    public String getCartLinkText() {
        Button cartLinkButton = new Button(driver, cartLinkLocator);
        return cartLinkButton.getText();
    }

    public void selectProductByName(String productName) {
        By productLocator = By.xpath("//*[@id='tbodyid']/div[1]/div/div/h4/a[contains(text(), '" + productName + "')]");
        Button productButton = new Button(driver, productLocator);
        productButton.click();
    }
}
