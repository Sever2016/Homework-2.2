package org.skypro.skyshop.product;

public abstract class Product {
    protected String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();
}
