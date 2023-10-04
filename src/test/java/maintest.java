import Pages.*;
import org.openqa.selenium.WebDriver;
import resources.DriverManager;

public class maintest {
    public static void main(String[] args) {
        //should i put pages in main root or test root?
        //should i put headless mode and navigation to constructor?
        //why main method worked only after i put the below two lines?
        //should i add the tests to the tests folder?
        //scenario 2 didn't work without the wait statement
        //i want handle alert to be automatically executed

        // Initialize the WebDriver and DriverManager
        //driver manager i made
        DriverManager driverManager = new DriverManager();
        //set headless mode
        //driverManager.setHeadlessMode();
        //didn't work unless i put this
        driverManager.setHeadlessMode();

        WebDriver driver = driverManager.getDriver();

        // Create objects
        home_category homecategory = new home_category(driver);
        add_toCart addcart = new add_toCart(driver);
        go_cart cart = new go_cart(driver);
        place_order placeorder = new place_order(driver);
        purchase_page purchasepage = new purchase_page(driver);

        driverManager.navigateTo("https://www.demoblaze.com/index.html");
        homecategory.clickPhonesCategory();
        addcart.selectProductByName("Samsung galaxy s6");
        addcart.addToCart();
        addcart.handleAlert();
        cart.gotoCart();
        placeorder.placeOrder();
        purchasepage.completePurchase("name","country","city","card","month","year");
        purchasepage.verifyPurchaseConfirmationMessage();

        // Close the WebDriver after execution
        //driverManager.closeAfterExecution();
    }
}
