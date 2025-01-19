package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, LinkedList<Product>> basket;

    public ProductBasket() {
        basket = new HashMap<>();
    }

    public void addProduct(Product product) {
        basket.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
    }

    public List removeProduct(String name) {
        if (basket.isEmpty() || !basket.containsKey(name)) return new ArrayList<Product>();
        LinkedList<Product> removedProducts = basket.remove(name);
        return removedProducts;
    }

    public int fullPrice() {
        if (basket.isEmpty()) return 0;
        int fullPrice = 0;
        for (LinkedList<Product> products : basket.values()) {
            for(Product product : products) {
                fullPrice += product.getPrice();
            }
        }
        return fullPrice;
    }

    public void printBasket() {
        StringBuilder basketPrint = new StringBuilder();
        int countSpecial = 0;
        for (Map.Entry<String, LinkedList<Product>> entry : basket.entrySet()) {
            for(Product product : entry.getValue()) {
                basketPrint.append(product).append("\n");
                if(product.isSpecial()) countSpecial++;
            }
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
        if (basket.isEmpty()) return false;
        return basket.containsKey(name);
    }

    public void deleteBasket() {
        basket.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBasket that = (ProductBasket) o;
        return Objects.equals(basket, that.basket);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(basket);
    }
}
