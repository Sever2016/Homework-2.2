package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int PRICE = 25;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public String toString() {
        return this.productName + ": " + this.getPrice();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
