import base.LoadProperties;
import enums.Products;
import org.openqa.selenium.WebDriver;
import actions.*;
import org.testng.annotations.*;
import pages.ShoppingCartReviewPage;
import pojo.Book;
import utils.DriverUtils;
import static org.testng.Assert.assertEquals;

public class PurchaseOrderTest {

    public WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "drivers\\chromedriver.exe");
        driver = DriverUtils.getDriver();
        driver.manage().window().maximize();
    }

    @Test()
    public void test_Login(){
        Products testBook = Products.HITCHHIKERS_GUIDE;
        OrderActions orderActions = new OrderActions();
        String username = LoadProperties.user.getProperty("tester23.username");
        String password = LoadProperties.user.getProperty("tester23.password");
        orderActions.navigateToHomePage();
        orderActions.loginAs(username, password);
        Book bookProductPage = orderActions.loadProductPageDataIntoProductObject(testBook);
        orderActions.initializeLogin();
    }

   /*@Parameters( {"testBook"} )
   @Test()
    public void test_createPurchaseOrderForSingleProduct(Products testBook){
        String username = LoadProperties.user.getProperty("tester23.username");
        String password = LoadProperties.user.getProperty("tester23.password");
        OrderActions orderActions = new OrderActions();
        ShoppingCartReviewPage shoppingCartReviewPage = new ShoppingCartReviewPage();

        orderActions.initializeLogin();
        orderActions.navigateToHomePage();
        orderActions.loginAs(username, password);
        orderActions.initializeCart();

        Book bookProductPage = orderActions.loadProductPageDataIntoProductObject(testBook);
        orderActions.addProductToShoppingCartReview(testBook);
        String actualCartSubtotalPrice = shoppingCartReviewPage.getCartSubtotal();
        String expectedBookPrice =  bookProductPage.getOfferPrice();
        orderActions.checkMatchingValues("Verify the Price Listed for the book:", actualCartSubtotalPrice, expectedBookPrice);
        assertEquals(actualCartSubtotalPrice, expectedBookPrice, "SHOPPING_CART_REVIEW: Cart Subtotal not what is expected!");
        Book bookShoppingCart = orderActions.loadShoppingCartDataIntoProductObject(testBook);
    }*/

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}