package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class go_cart {
    private By cartLocator = By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a");
    private WebDriver driver;

    public go_cart(WebDriver driver) {
        this.driver = driver;
    }

    public void gotoCart() {
        WebElement cartElement = driver.findElement(cartLocator);
        cartElement.click();
    }

}
