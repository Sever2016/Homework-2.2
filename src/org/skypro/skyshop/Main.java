package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

public class Main {
    public static void main(String[] args) {
        //Блок старого дз
        Product apple = new SimpleProduct("Apple", 45);
        Product grape = new DiscountProduct("Grape", 325, 15);
        ProductBasket firstBucket = new ProductBasket();
        firstBucket.addProduct(apple);
        firstBucket.addProduct(grape);


        Product buckwheat = new SimpleProduct("AAпельсино", 325);
        Product onion = new FixPriceProduct("Onion");
        Product butter = new SimpleProduct("Butter", 68);
        Product berries = new SimpleProduct("Berries", 517);

        firstBucket.addProduct(buckwheat);
        firstBucket.addProduct(onion);
        firstBucket.addProduct(butter);
        firstBucket.addProduct(berries);
        firstBucket.addProduct(onion);
        firstBucket.printProductBucket();
        System.out.println(firstBucket.countProductBasketPrice());
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

        product = "Onion";
        if (firstBucket.isProductInBasket(product)) {
            System.out.println(product + " есть в корзине");
        } else {
            System.out.println(product + " нет в корзине");
        }

        Article onionArticle = new Article("Onion", "Почему лук заставляет плакать?");
        Article cookiesArticle = new Article("Cookies", "Вкусно и полезно, но как?");
        Article amberArticle = new Article("Amber", "Сочно, дерзко, аппетитно");

        SearchEngine testSearch = new SearchEngine();
        testSearch.add(apple);
        testSearch.add(grape);
        testSearch.add(null);
        testSearch.add(berries);
        testSearch.add(buckwheat);
        testSearch.add(butter);
        testSearch.add(onionArticle);
        testSearch.add(cookiesArticle);
        testSearch.add(amberArticle);

        System.out.println();
        System.out.println(testSearch.search("Onion"));

        System.out.println();
        System.out.println(testSearch.search("дерзко"));

        System.out.println();
        System.out.println(testSearch.search("Berries"));

        System.out.println();
        System.out.println(testSearch.search("Чудофрукт"));

        System.out.println();

        try {
            SimpleProduct Sausage = new SimpleProduct("Sausage", 0);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception);
        }
        try {
            DiscountProduct Eggs = new DiscountProduct("Eggs", 90, 101);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception);
        }
        try {
            SimpleProduct Cake = new SimpleProduct("", 150);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception);
        }

        System.out.println();

        try {
            System.out.println(testSearch.getSearchTerm("но"));
            System.out.println();
            System.out.println(testSearch.getSearchTerm("Что такое ананас?"));
        } catch (BestResultNotFound exception) {
            System.out.println(exception);
        }

        System.out.println();
        System.out.println("Просмотр работы по Java Collections");
        System.out.println();
        System.out.println("Были удалены " + firstBucket.deleteProduct("Onion"));
        System.out.println();
        firstBucket.printProductBucket();
        System.out.println();
        if (firstBucket.deleteProduct("Table").isEmpty()) {
            System.out.println("Список пуст");
        }
        System.out.println();
        firstBucket.printProductBucket();
        System.out.println(testSearch.search("но"));
    }
}