package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, ArrayList<Product>> productBasket = new HashMap<>();

    public void addProduct(Product newProduct) {
        productBasket.computeIfAbsent(newProduct.getProductName(), k -> new ArrayList<>()).add(newProduct);
    }
    djkbbjc

    public int countProductBasketPrice() {
        int totalPrice = 0;
        for (ArrayList<Product> product : productBasket.values()) {
            if (product != null) {
                totalPrice += product.get(0).getPrice() * product.size();
            }
        }
        return totalPrice;
    }

    public int countSpecialProducts() {
        int specialProducts = 0;
        for (ArrayList<Product> product : productBasket.values()) {
            if (product != null && product.get(0).isSpecial()) {
                specialProducts += product.size();
            }
        }
        return specialProducts;
    }

    public void printProductBucket() {
        boolean isEmpty = true;
        for (Map.Entry<String, ArrayList<Product>> product : productBasket.entrySet()) {
            if (product != null) {
                isEmpty = false;
                System.out.println(product);
            }
        }
        if (isEmpty) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + countProductBasketPrice());
            System.out.println("Специальных товаров: " + countSpecialProducts());
        }
    }

    public boolean isProductInBasket(String productName) {
        boolean isProductInBasket = false;
        for (String product : productBasket.keySet()) {
            if (productName.equals(product)) {
                isProductInBasket = true;
                break;
            }
        }
        return isProductInBasket;
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
