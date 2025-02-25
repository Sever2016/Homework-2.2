package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, ArrayList<Product>> productBasket = new HashMap<>();

    public void addProduct(Product newProduct) {
        productBasket.computeIfAbsent(newProduct.getProductName(), k -> new ArrayList<>()).add(newProduct);
    }

    public int countProductBasketPrice() {
        return productBasket.values().stream().flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public long countSpecialProducts() {
        return productBasket.values().stream().flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .count();

    }

    public void printProductBucket() {
        productBasket.entrySet().stream()
                .filter(Objects::nonNull)
                .forEach(System.out::println);
        if (productBasket.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Специальных товаров: " + countSpecialProducts());
        }
    }

    public boolean isProductInBasket(String productName) {
        return productBasket.keySet().stream()
                .anyMatch(i -> i.equals(productName));
    }

    public void cleanProductBasket() {
        productBasket.clear();
    }

    public Map<String, ArrayList<Product>> deleteProduct(String name) {
        Map<String, ArrayList<Product>> deletedProducts = new HashMap<>();
        deletedProducts.put(name, productBasket.get(name));
        productBasket.remove(name);
        return deletedProducts;
    }
}
