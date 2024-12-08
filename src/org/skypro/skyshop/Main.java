package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class Main {
    public static void main(String[] args) {
        Product apple = new Product("Apple", 45);
        Product grape = new Product("Grape", 325);
        ProductBasket firstBucket = new ProductBasket();
        firstBucket.addProduct(apple);
        firstBucket.addProduct(grape);

        firstBucket.printProductBucket();
        System.out.println(firstBucket.countProductBasketPrice());

        Product buckwheat = new Product("Buckwheat", 325);
        Product onion = new Product("Onion", 34);
        Product butter = new Product("Butter", 68);
        Product berries = new Product("Berries", 517);

        System.out.println();
        firstBucket.addProduct(buckwheat);
        firstBucket.addProduct(onion);
        firstBucket.addProduct(butter);
        firstBucket.addProduct(berries);
        firstBucket.printProductBucket();
        System.out.println();

        String product = "Onion";
        if (firstBucket.isProductInBasket(product)) {
            System.out.println(product + " есть в корзине");
        } else {
            System.out.println(product + " нет в корзине");
        }
        product = "Berries";
        if (firstBucket.isProductInBasket(product)) {
            System.out.println(product + " есть в корзине");
        } else {
            System.out.println(product + " нет в корзине");
        }
        System.out.println();

        firstBucket.cleanProductBasket();
        firstBucket.printProductBucket();
        firstBucket.countProductBasketPrice();
        product = "Onion";
        if (firstBucket.isProductInBasket(product)) {
            System.out.println(product + " есть в корзине");
        } else {
            System.out.println(product + " нет в корзине");
        }
    }
}