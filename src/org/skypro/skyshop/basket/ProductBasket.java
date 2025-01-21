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
        return basket.values().stream().flatMap(Collection::stream).mapToInt(Product::getPrice).sum();
    }


    public void printBasket() {
        StringBuilder basketPrint = new StringBuilder();

        basket.values().stream().flatMap(Collection::stream).forEach(product -> basketPrint.append(product).append("\n"));
        int countSpecial = (int) basket.values().stream().flatMap(Collection::stream).filter(Product::isSpecial).count();

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
