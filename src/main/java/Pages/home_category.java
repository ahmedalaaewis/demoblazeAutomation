package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class home_category
{
    private WebDriver driver;

    private By phonesCategoryLocator = By.cssSelector("a#itemc[onclick*='phone']");
    private By laptopsCategoryLocator = By.cssSelector("a#itemc[onclick*='notebook']");
    private By monitorsCategoryLocator = By.cssSelector("a#itemc[onclick*='monitor']");


    public home_category(WebDriver driver) {
        this.driver = driver;

    }

    public void clickPhonesCategory() {
        WebElement mobilesCategoryElement = driver.findElement(phonesCategoryLocator);
        mobilesCategoryElement.click();
    }

    public void clickLaptopsCategory() {
        WebElement laptopsCategoryElement = driver.findElement(laptopsCategoryLocator);
        laptopsCategoryElement.click();
    }

    public void clickMonitorsCategory(){
        WebElement monitorCategoryElement = driver.findElement(monitorsCategoryLocator);
        monitorCategoryElement.click();
    }

}
