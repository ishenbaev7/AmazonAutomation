import actions.OrderActions;
import base.LoadProperties;
import enums.Books;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BestSellersPage;
import pages.HomePage;
import pages.ShoppingCartReviewPage;
import pojo.Book;
import utils.DetectOS;
import utils.DriverUtils;
import static org.testng.Assert.assertEquals;

public class PurchaseOrderTest {

    public WebDriver driver;

    @BeforeClass
    public void setUp(){
        if (DetectOS.isMac())
        System.setProperty("webdriver.chrome.driver",
                "drivers//mac//chromedriver");
        else
            System.setProperty("webdriver.chrome.driver",
                    "drivers//win//chromedriver.exe");
        driver = DriverUtils.getDriver();
        driver.manage().window().maximize();
    }

    @Test(enabled = false)
    public void test_Login(){
        Books testBook = Books.HITCHHIKERS_GUIDE;
        OrderActions orderActions = new OrderActions();
        String username = LoadProperties.user.getProperty("tester23.username");
        String password = LoadProperties.user.getProperty("tester23.password");
        orderActions.navigateToHomePage();
        orderActions.loginAs(username, password);
        Book bookProductPage = orderActions.loadProductPageDataIntoBookObject(testBook);
        orderActions.initializeLogin();
    }
    @Test()
    public void test_BestSellers(){
        BestSellersPage bestSellersPage = new BestSellersPage();
        bestSellersPage.navigateToBestSellersPage();
        bestSellersPage.Print_Products_Name(bestSellersPage.Get_All_Best_Seller_Products());
    }
   @Parameters( {"testBook"} )
   @Test(enabled = false)
    public void test_createPurchaseOrderForSingleProduct(Books testBook){
        String username = LoadProperties.user.getProperty("tester23.username");
        String password = LoadProperties.user.getProperty("tester23.password");
        OrderActions orderActions = new OrderActions();
        ShoppingCartReviewPage shoppingCartReviewPage = new ShoppingCartReviewPage();

        orderActions.initializeLogin();
        orderActions.navigateToHomePage();
        orderActions.loginAs(username, password);
        orderActions.initializeCart();

        Book bookProductPage = orderActions.loadProductPageDataIntoBookObject(testBook);
        orderActions.addProductToShoppingCartReview(testBook);
        String actualCartSubtotalPrice = shoppingCartReviewPage.getCartSubtotal();
        String expectedBookPrice =  bookProductPage.getOfferPrice();
        orderActions.checkMatchingValues("Verify the Price Listed for the book:", actualCartSubtotalPrice, expectedBookPrice);
        assertEquals(actualCartSubtotalPrice, expectedBookPrice, "SHOPPING_CART_REVIEW: Cart Subtotal not what is expected!");
        Book bookShoppingCart = orderActions.loadShoppingCartDataIntoProductObject(testBook);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}