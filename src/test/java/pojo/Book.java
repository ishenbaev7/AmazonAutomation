package pojo;

import org.testng.TestException;
import pages.ProductPage;

public class Book extends Product {
    private String author = "";
    private String edition = "";

    public Book(){
    }

    @Override
    public String toString(){
        return String.format(
                "Product Title:  " + super.getProductTitle() + "\n"
                        + "Author: " + this.author + "\n"
                        + "Edition:  " + this.edition + "\n"
                        + "Offer Price:  " + super.getOfferPrice() + "\n"
        );
    }

    public void loadInfoFromProductPage(){
        ProductPage productPage = new ProductPage();
        String currentURL = productPage.getCurrentURL();

        if (!currentURL.contains("product")){
            throw new TestException("LOAD INFO ERROR: Product data should only be loaded from product page!\nCurrent URL: " + currentURL);
        } else {
            System.out.println("LOAD_INFO: Loading data...\n");
            super.setProductTitle(productPage.getProductTitle());
            this.author = productPage.getAuthor();
            super.setOfferPrice(productPage.getPrice());
            this.edition = productPage.getEdition();
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOfferPrice() {
        return super.getOfferPrice();
    }

    public void setOfferPrice(String offerPrice) {
        super.setOfferPrice(offerPrice);
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

}