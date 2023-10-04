package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class place_order {
    private WebDriver driver;
    private By placeorderLocator = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");


    public place_order(WebDriver driver){
        this.driver = driver;
    }
    public void placeOrder(){
        WebElement placeOrderElement = driver.findElement(placeorderLocator);
        placeOrderElement.click();
    }
}
