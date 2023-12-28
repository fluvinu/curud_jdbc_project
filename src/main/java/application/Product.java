package application;

public class Product {
    private int productId;
    private String productName;
    private double productPrice;
    private String producType;

    public Product(int productId, String productName, double productPrice, String producType) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.producType = producType;
    }


    public Product(){

    }


    public Product(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

//    public void setProductId(int productId) {
//        this.productId = productId;
//    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProducType() {
        return producType;
    }

    public void setProducType(String producType) {
        this.producType = producType;
    }
}
