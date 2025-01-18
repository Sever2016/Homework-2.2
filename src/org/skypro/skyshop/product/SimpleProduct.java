package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String productName, int price) {
        super(productName);
        this.price = price;
        if (this.price < 1) {
            throw new IllegalArgumentException("Продукт должен что-нибудь стоить");
        }
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
