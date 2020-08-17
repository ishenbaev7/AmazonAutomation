package actions;

import enums.Books;
import pages.*;
import pojo.Book;
import pojo.Product;

public class OrderActions {

    public void navigateToHomePage(){
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
    }

    public void loginAs(String username, String password){
        HomePage homePage = new HomePage();
        SignInPage signIn = new SignInPage();
        homePage.navigateToSignInPage();
        signIn.enterUsername(username);
        signIn.clickContinueButton();

        signIn.enterPassword(password);
        signIn.clickSignInButton();
    }

    public Book loadProductPageDataIntoBookObject(Books book_enum){
        System.out.println("Starting process to load info for " + book_enum + ":");
        Book book = new Book();
        ProductPage productPage = new ProductPage();
        productPage.navigateToProductPage(book_enum);
        productPage.verifyProductTitle(book.getProductTitle());
        book.loadInfoFromProductPage();
        System.out.println(book + "\n");
        return book;
    }

    public void addProductToShoppingCartReview(Books product){
        ShoppingCartReviewPage shoppingCartReviewPage = new ShoppingCartReviewPage();
        System.out.println("Adding " + product + " to cart:");
        ProductPage productPage = new ProductPage();
        productPage.navigateToProductPage(product);
        productPage.verifyProductTitle(product.getProductTitle());
        productPage.clickAddToCart();
        shoppingCartReviewPage.verifyOnShoppingCartReviewPage();
    }

    public Book loadShoppingCartDataIntoProductObject(Books product){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        Book book = new Book();
        shoppingCartPage.verifyOnShoppingCartPage();

        return book;
    }

    public void initializeLogin(){
        System.out.println("INITIALIZING: Signing out, if needed.\n");
        signOut();
    }

    public void initializeCart(){
        System.out.println("INITIALIZING: Deleting all Items in Cart.\n");
        deleteAllItemsIfAnyFromCart();
    }

    public void signOut(){
        HomePage homePage = new HomePage();
        homePage.signOutWithSignOutLink();
    }

    public void deleteAllItemsIfAnyFromCart(){
        HomePage homePage = new HomePage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        String itemsInCart = homePage.getNumberOfItemsListedInShoppingCartIcon();
        if (!itemsInCart.equals("0")){
            homePage.selectShoppingCartIcon();
            shoppingCartPage.deleteAllItemsInCart();
        } else {
            System.out.println("\t* There are already '0' items in the Shopping Cart.");
        }
    }

    private String outputPassOrFailOnFieldComparison(String fieldName, String actualValue, String expectedValue){
        if (actualValue.equals(expectedValue)){
            return "\t* " + fieldName + ": '" + actualValue + "' (PASS)";
        } else {
            return "\t* " + fieldName + ": '" + actualValue + "' : Should be: '" + expectedValue + "' (FAIL)";
        }
    }

    public boolean checkMatchingValues(String testHeading, Object actualValue, Object expectedValue) {
        String successMessage = "\t* The Expected and Actual Values match. (PASS)\n";
        String failureMessage = "\t* The Expected and Actual Values do not match! (FAIL)\n";

        boolean doesPriceMatch = false;

        System.out.println(testHeading);
        System.out.println("\t* Expected Value: " + expectedValue);
        System.out.println("\t* Actual Value: " + actualValue);

        if (actualValue.equals(expectedValue)) {
            System.out.println(successMessage);
            doesPriceMatch = true;
        } else {
            System.out.println(failureMessage);
            doesPriceMatch = false;
        }
        return doesPriceMatch;
    }
}