package pages;

import enums.Books;
import enums.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;

import java.util.List;

public class BestSellersPage extends CommonUtils {
    private final By PRODUCTS_NAME = By.className("p13n-sc-truncated");
    public BestSellersPage(){
    }

    public List<WebElement> Get_All_Best_Seller_Products(){
        List<WebElement> products = getElements(PRODUCTS_NAME);
        return products;
    }
    public void navigateToBestSellersPage(){
        String url = Url.BASEURL.getURL() + Url.BESTSELLERS_SECTION.getURL() + "/" ;
        navigateToURL(url);
        System.out.println("Best Sellers_PAGE: Navigated to " + url);
    }
    public void Print_Products_Name(List<WebElement> products){
        for (WebElement product:products) {
            System.out.println(product.getText());
        }
    }
}