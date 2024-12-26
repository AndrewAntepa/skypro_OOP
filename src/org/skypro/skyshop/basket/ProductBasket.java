package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] basket;
    private int count = 0;
    private static final int LENGTH = 5;

    public ProductBasket() {
        basket = new Product[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            basket[i] = null;
        }
    }

    public void addProduct(Product product) {
        if(count == LENGTH) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        basket[count++] = product;
    }

    public int fullPrice() {
        if (count == 0) return 0;
        int fullPrice = 0;
        for (Product product : basket) {
            fullPrice += product.getPrice();
        }
        return fullPrice;
    }

    public void printBasket() {
        StringBuilder basketPrint = new StringBuilder();
        int countSpecial = 0;
        for (Product product : basket) {
            if(product == null) continue;
            basketPrint.append(product).append("\n");
            if(product.isSpecial()) countSpecial++;
        }
        if(countSpecial != 0) {
            basketPrint.append("Специальных товаров: ").append(countSpecial).append("\n");
        }
        if (basketPrint.isEmpty()) {
            basketPrint.append("В корзине пусто");
        }
        System.out.println(basketPrint);
    }

    public boolean isHasProduct(String name) {
        if (count == 0) return false;
        for (Product product : basket) {
            if (product.getName().equals(name)) return true;
        }
        return false;
    }

    public void deleteBasket() {
        basket = new Product[LENGTH];
        count = 0;
    }
}
