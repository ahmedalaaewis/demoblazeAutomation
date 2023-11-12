package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.DemoBlazePOM;
import resources.DriverManager;

public class DemoBlazeTest {
    private WebDriver driver;
    private DemoBlazePOM demoBlaze;

    @BeforeMethod
    public void setUp() {
        DriverManager driverManager = new DriverManager();
        //driverManager.setHeadlessMode(); // Set headless mode if needed
        driver = driverManager.getDriver();
        demoBlaze = new DemoBlazePOM(driver);
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testScenario_ChoosePhoneCategory() {
        demoBlaze.navigateToHomePage();
        demoBlaze.choosePhonesCategory();
        demoBlaze.selectProductByName("Samsung galaxy s6");

        String cartLinkText = demoBlaze.getCartLinkText();
        // You can add assertions to validate the test results.
    }

    @Test
    public void testScenario_chooseLaptopCategory() {
        demoBlaze.navigateToHomePage();
        demoBlaze.chooseLaptopsCategory();
        demoBlaze.selectProductByName("Sony vaio i5");

        String cartLinkText = demoBlaze.getCartLinkText();
        // You can add assertions to validate the test results.
    }
}
