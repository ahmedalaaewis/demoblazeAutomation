package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class add_toCart {
    private WebDriver driver;

    public add_toCart(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProductByName(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By productLocator = By.xpath("//*[@id='tbodyid']/div[1]/div/div/h4/a[contains(text(), '" + productName + "')]");
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(productLocator));
        productElement.click();
    }

    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By addToCartLocator = By.xpath("//a[contains(@onclick, 'addToCart') and contains(@class, 'btn-success')]");
        WebElement addToCartElement = wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator));
        addToCartElement.click();
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void acceptAlert() {
        if(isAlertPresent());
        {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }

    public void handleAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException ex) {
            // Handle the case where the alert is not present
            // This could be due to various reasons, such as timing issues
            // Handle as needed
        }
    }


}
