package org.skypro.skyshop.product;

public class DiscountProduct extends Product {
    private int usualPrice, discount;
    public DiscountProduct(String productName, int usualPrice, int discount) {
        super(productName);
        this.usualPrice = usualPrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return this.usualPrice - this.usualPrice * this.discount / 100;
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