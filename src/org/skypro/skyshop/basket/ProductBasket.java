package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {

    Product[] productBasket = new Product[5];

    public void addProduct(Product newProduct) {
        boolean isFull = true;
        for (int i = 0; i < 5; i++) {
            if (this.productBasket[i] == null) {
                isFull = false;
                this.productBasket[i] = newProduct;
                break;
            }
        }
        if (isFull) {
            System.out.println("Невозможно добавить продукт");
        }
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

    public void printProductBucket() {
        boolean isEmpty = true;
        for (Product product : productBasket) {
            if (product != null) {
                isEmpty = false;
                System.out.println(product.getProductName() + ": " + product.getPrice());
            }
        }
        if (isEmpty) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + countProductBasketPrice());
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
        Arrays.fill(productBasket, null);
    }
}
