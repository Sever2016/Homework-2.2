package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    List<Product> productBasket = new LinkedList<>();

    public void addProduct(Product newProduct) {
        productBasket.add(newProduct);
    }

    public int countProductBasketPrice() {
        int totalPrice = 0;
        for (Product product : productBasket) {
            if (product != null) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    public int countSpecialProducts() {
        int specialProducts = 0;
        for (Product product : productBasket) {
            if (product != null && product.isSpecial()) {
                specialProducts++;
            }
        }
        return specialProducts;
    }

    public void printProductBucket() {
        boolean isEmpty = true;
        for (Product product : productBasket) {
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
        for (Product product : productBasket) {
            if (product != null && productName.equals(product.getProductName())) {
                isProductInBasket = true;
                break;
            }
        }
        return isProductInBasket;
    }

    public void cleanProductBasket() {
        productBasket.clear();
    }

    public List<Product> deleteProduct(String name) {
        List<Product> deletedProducts = new LinkedList<>();
        Iterator<Product> iterator = productBasket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (name.equals(product.getProductName())) {
                deletedProducts.add(product);
                iterator.remove();
            }
        }
        return deletedProducts;
    }
}
