package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoBlazePOM {
    private WebDriver driver;
    private WebDriverWait wait;

    // Define locators for elements on the page
    private By laptopsCategoryLocator = By.cssSelector("a#itemc[onclick*='notebook']");
    private By phonesCategoryLocator = By.cssSelector("a#itemc[onclick*='phone']");
    private By cartLinkLocator = By.id("cartur");

    public DemoBlazePOM(WebDriver driver) {
        this.driver = driver;

        // Initialize the WebDriverWait with a 10-second timeout
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Methods to interact with the page
    public void navigateToHomePage() {
        String url = "https://www.demoblaze.com/index.html";
        driver.get(url);
    }

    public void chooseLaptopsCategory() {
        WebElement laptopsCategoryElement = wait.until(ExpectedConditions.elementToBeClickable(laptopsCategoryLocator));
        laptopsCategoryElement.click();
    }

    public void choosePhonesCategory() {
        WebElement phonesCategoryElement = wait.until(ExpectedConditions.elementToBeClickable(phonesCategoryLocator));
        phonesCategoryElement.click();
    }

    public void addToCart() {
        By addToCartButtonLocator = By.xpath("//a[contains(@onclick, 'addToCart') and contains(@class, 'btn-success')]");
        WebElement addToCartElement = wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonLocator));
        addToCartElement.click();
    }

    public void viewCart() {
        WebElement cartLinkElement = wait.until(ExpectedConditions.elementToBeClickable(cartLinkLocator));
        cartLinkElement.click();
    }

    public String getCartLinkText() {
        WebElement cartLinkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartLinkLocator));
        return cartLinkElement.getText();
    }

    public void selectProductByName(String productName) {
        By productLocator = By.xpath("//*[@id='tbodyid']/div[1]/div/div/h4/a[contains(text(), '" + productName + "')]");
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(productLocator));
        productElement.click();
    }
}
