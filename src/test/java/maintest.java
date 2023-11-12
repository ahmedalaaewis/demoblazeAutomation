import Pages.*;
import org.openqa.selenium.WebDriver;
import resources.DriverManager;

public class maintest {
    public static void main(String[] args) {

        DriverManager driverManager = new DriverManager();
        //driverManager.setHeadlessMode();

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
