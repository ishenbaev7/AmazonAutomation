package enums;

public enum Products {
    HITCHHIKERS_GUIDE("0345391802", "The Hitchhiker's Guide to the Galaxy"),
    THE_HOBBIT("0345339681", "The Hobbit"),
    RINGWORLD("0345333926", "Ringworld"),
    FOUNDATION("0553293354", "Foundation");
    // The price will always fluctuate. The product id and product title will be more or less constant.
    private String id;
    private String productTitle;

    Products(String id, String productTitle) {
        this.id = id;
        this.productTitle = productTitle;
    }

    public String getProductId() {
        return id;
    }

    public String getProductTitle() {
        return productTitle;
    }
}