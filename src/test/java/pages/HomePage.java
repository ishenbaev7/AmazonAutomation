package pages;

import enums.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;

import java.util.List;

public class HomePage extends CommonUtils {
    private final By YOUR_ACCOUNT = By.className("nav-line-1");
    private final By SHOPPING_CART_ICON = By.cssSelector("#nav-cart");
    private final By SHOPPING_CART_COUNT = By.cssSelector("#nav-cart > #nav-cart-count");
   private final By SIGNIN_BUTTON = By.cssSelector("#a-autoid-0-announce");
    private final By AMAZONLOGO = By.className("nav-logo-link");
    private final By BESTSELLERS_BUTTON = By.id("nav-xshop");
    public HomePage(){
    }

    public void navigateToHomePage() {
        String url = Url.BASEURL.getURL();
        System.out.println("Navigating to Amazon.com: " + url);
        navigateToURL(url);
    }

    public void navigateToSignInPage(){
        System.out.println("HOME_PAGE: Selecting [YOUR_ACCOUNT] in navigation bar.");
        click(AMAZONLOGO);
        scrollToThenClick(SIGNIN_BUTTON);
        System.out.println("HOME_PAGE: Navigating to the SIGNIN_PAGE.\n");
    }

    public void signOutWithSignOutLink(){
        String url = Url.BASEURL.getURL() + Url.SIGNOUT.getURL();
        navigateToURL(url);
    }

    public void selectShoppingCartIcon(){
        click(SHOPPING_CART_ICON);
    }

    public String getNumberOfItemsListedInShoppingCartIcon(){
        return getElementText(SHOPPING_CART_COUNT);
    }
}