package org.skypro.skyshop.product;

import org.skypro.skyshop.interfaces.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        Product product = (Product) obj;
        return Objects.equals(product.productName, this.productName);
    }

    @Override
    public int hashCode() {
        return this.productName.hashCode();
    }
}
