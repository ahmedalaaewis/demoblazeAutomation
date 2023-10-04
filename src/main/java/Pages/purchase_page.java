package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class purchase_page {
    private WebDriver driver;

    public purchase_page(WebDriver driver) {
        this.driver = driver;
    }

    public void completePurchase(String name, String country, String city, String card, String month, String year) {

        // Switch to the pop-up window
        String mainWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        By nameLocator = By.id("name");
        WebElement nameElement = driver.findElement(nameLocator);
        nameElement.sendKeys(name);

        By countryLocator = By.id("country");
        WebElement countryElement = driver.findElement(countryLocator);
        countryElement.sendKeys(country);

        By cityLocator = By.id("city");
        WebElement cityElement = driver.findElement(cityLocator);
        cityElement.sendKeys(city);

        By cardLocator = By.id("card");
        WebElement cardElement = driver.findElement(cardLocator);
        cardElement.sendKeys(card);

        By monthLocator = By.id("month");
        WebElement monthElement = driver.findElement(monthLocator);
        monthElement.sendKeys(month);

        By yearLocator = By.id("year");
        WebElement yearElement = driver.findElement(yearLocator);
        yearElement.sendKeys(year);

        // Click on the "Purchase" button in the pop-up window
        WebElement purchaseButton = driver.findElement(By.xpath("//button[contains(text(), 'Purchase')]"));
        purchaseButton.click();

        // Switch back to the main window
        //driver.switchTo().window(mainWindow);
    }

    public void verifyPurchaseConfirmationMessage() {
        // Locate the "Thank you for your purchase!" message
        By thankYouMessageLocator = By.xpath("//*[contains(text(), 'Thank you for your purchase!')]");
        WebElement thankYouMessageElement = driver.findElement(thankYouMessageLocator);

        // Assert that the message "Thank you for your purchase!" is displayed
        boolean isThankYouMessageDisplayed = thankYouMessageElement.isDisplayed();
        Assert.assertTrue(isThankYouMessageDisplayed, "Expected message 'Thank you for your purchase!' not found.");

        //just to check if the assertion really worked
        if (isThankYouMessageDisplayed) {
            System.out.println("Assertion passed: 'Thank you for your purchase!' is displayed.");
        } else {
            System.out.println("Assertion failed: 'Thank you for your purchase!' is not displayed.");
        }
        // Locate the purchase details element
        By purchaseDetailsLocator = By.xpath("/html/body/div[10]/p");
        WebElement purchaseDetailsElement = driver.findElement(purchaseDetailsLocator);

        // Get the text of the purchase details
        String purchaseDetailsText = purchaseDetailsElement.getText();

        // Print the purchase details
        System.out.println("Purchase Confirmation Details:\n " + purchaseDetailsText);
    }

}

