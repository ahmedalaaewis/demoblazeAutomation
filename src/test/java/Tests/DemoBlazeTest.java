package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.home_category;
import resources.DriverManager;

public class Test1_chooseCategory {
    private WebDriver driver;
    private DriverManager driverManager;

    @BeforeMethod
    public void setUp() {
        // Initialize the WebDriver and resources.DriverManager
        driverManager = new DriverManager();
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        // Close the WebDriver after each test method
        //driverManager.closeAfterExecution();
    }

    @Test
    public void testScenario_ChoosePhoneCategory() {
        home_category homeCategoryPage = new home_category(driver);

        driverManager.navigateTo("https://www.demoblaze.com/index.html");
        homeCategoryPage.clickPhonesCategory();
    }

    @Test
    public void testScenario_chooseLaptopCategory() {
        home_category homeCategoryPage = new home_category(driver);

        driverManager.navigateTo("https://www.demoblaze.com/index.html");
        homeCategoryPage.clickLaptopsCategory();
    }
}
