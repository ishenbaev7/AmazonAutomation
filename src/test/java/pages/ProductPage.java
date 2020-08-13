package pages;

import enums.Products;
import enums.Url;
import org.openqa.selenium.By;
import org.testng.TestException;
import utils.CommonUtils;

public class ProductPage extends CommonUtils {

    private final By PRODUCT_TITLE = By.cssSelector("#productTitle");
    private final By AUTHOR = By.cssSelector(".a-link-normal.contributorNameID");
    private final By EDITION = By.cssSelector("#productDetailsTable > tbody > tr > td > div > ul > li:nth-child(3)");
    private final By PRICE = By.id("price");
    private final By ADD_TO_CART = By.cssSelector("#add-to-cart-button");

    public void navigateToProductPage(Products product){
        String url = Url.BASEURL.getURL() + Url.PRODUCT_SECTION.getURL() + "/" + product.getProductId();
        navigateToURL(url);
        System.out.println("PRODUCT_PAGE: Navigated to " + url);
    }

    public void verifyProductTitle(String expectedTitle){
        String actualTitle = getProductTitle();
        System.out.println("PRODUCT_PAGE: Verifying that the product title is '" + actualTitle + "'");
        if (!expectedTitle.equals(actualTitle)){
            throw new TestException("ERROR: PRODUCT_PAGE: Product Title is ['" + actualTitle + "']. Expected ['" + expectedTitle + "'].");
        }
    }

    public String getProductTitle(){
        return getElementText(PRODUCT_TITLE);
    }

    public String getAuthor(){
        return getElementText(AUTHOR);
    }

    public String getEdition(){
        return getElementText(EDITION);
    }

    public String getPrice(){
        return getElementText(PRICE);
    }

    public void clickAddToCart(){
        System.out.println("PRODUCT_PAGE: Clicking on [ADD_TO_CART] button. \n");
        click(ADD_TO_CART);
    }
}