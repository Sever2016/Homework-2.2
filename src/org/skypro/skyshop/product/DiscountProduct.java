package org.skypro.skyshop.product;

public class DiscountProduct extends Product {
    private int usualPrice, discount;
    public DiscountProduct(String productName, int usualPrice, int discount) {
        super(productName);
        this.usualPrice = usualPrice;
        if (usualPrice < 1) {
            throw new IllegalArgumentException("Продкут должен что-нибудь стоить");
        }
        this.discount = discount;
        if (this.discount < 0 || this.discount > 100) {
            throw new IllegalArgumentException("Неверное значение скидки товара");
        }
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
