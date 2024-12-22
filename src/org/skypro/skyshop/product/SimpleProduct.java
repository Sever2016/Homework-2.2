package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;
    public SimpleProduct(String productName, int price) {
        super(productName);
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return this.productName + ": " + this.getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
