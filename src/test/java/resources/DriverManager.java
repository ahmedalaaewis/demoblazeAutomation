package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    private WebDriver driver;
    private FirefoxOptions options;

    public DriverManager() {
        options = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup(); // Use WebDriverManager to set up GeckoDriver
    }

    public void setHeadlessMode() {
        options.setHeadless(true);
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = new FirefoxDriver(options);
        }
        return driver;
    }

    public void navigateTo(String url) {
        getDriver().get(url);
    }

    public void closeAfterExecution() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
