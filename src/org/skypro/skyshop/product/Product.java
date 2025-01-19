package org.skypro.skyshop.product;

import org.skypro.skyshop.interfaces.Searchable;

public abstract class Product implements Searchable {
    protected String productName;

    public Product(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Неправильное название продукта");
        }
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getTypeOfContent() {
        return "PRODUCT";
    }

    @Override
    public String searchTerm() {
        return this.productName;
    }
}
