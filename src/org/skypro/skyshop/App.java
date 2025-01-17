package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFoundException;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        SimpleProduct product1 = new SimpleProduct("Сыр", 100);
        DiscountedProduct product2 = new DiscountedProduct("Молоко", 500, 20);
        DiscountedProduct product3 = new DiscountedProduct("Хлеб", 300, 40);
        SimpleProduct product3_2 = new SimpleProduct("Хлеб", 300);
        FixPriceProduct product4 = new FixPriceProduct("Вода");
        FixPriceProduct product5 = new FixPriceProduct("Кола");
        SimpleProduct product6 = new SimpleProduct("Кола", 600);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);
        basket.addProduct(product3_2);

        basket.printBasket();

        List removedProducts = basket.removeProduct("Хлеб");
        basket.printBasket();
        System.out.println("Удаленные товары: " + removedProducts);

        List removedProductsTry = basket.removeProduct("Торт");
        if (removedProductsTry.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            basket.printBasket();
        }
        System.out.println("Удаленные товары: " + removedProductsTry);

        System.out.println("Цена корзины: " + basket.fullPrice() + " руб.");

        System.out.println(basket.isHasProduct("Кола"));
        System.out.println(basket.isHasProduct("Колбаса"));

        basket.deleteBasket();
        basket.printBasket();
        System.out.println(basket.fullPrice());
        System.out.println(basket.isHasProduct("Колбаса"));


        System.out.println("\n===SearchEngine===\n");

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);

        Article article1 = new Article("Название статьи 1", "Текст статьи 1");
        Article article2 = new Article("Название статьи 2", "Текст статьи 2");
        Article article3 = new Article("Название статьи 3", "Текст статьи 3 текст текст");
        Article article4 = new Article("Название статьи 4", "Текст статьи 4");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);

        Map<String, Searchable> searchResults = searchEngine.search("PRODUCT");
        for (Map.Entry<String, Searchable> entry : searchResults.entrySet()) {
//            for(Searchable result : entry.getValue()) {
                if (entry == null) continue;
                System.out.println(entry);
//            }
        }
        System.out.println();

//        searchResults = searchEngine.search("ARTICLE");
//        for (Map.Entry<String, LinkedList<Searchable>> entry : searchResults.entrySet()) {
//            for(Searchable result : entry.getValue()) {
//                if (result == null) continue;
//                System.out.println(result);
//            }
//        }
//        System.out.println();
//
//        searchResults = searchEngine.search("Кола");
//        for (Map.Entry<String, LinkedList<Searchable>> entry : searchResults.entrySet()) {
//            for(Searchable result : entry.getValue()) {
//                if (result == null) continue;
//                System.out.println(result);
//            }
//        }
//        System.out.println();




        System.out.println("===Exceptions===\n");
        ProductBasket basketTryException = new ProductBasket();

        try {
            basketTryException.addProduct(new SimpleProduct("   ", 12));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            basketTryException.addProduct(new SimpleProduct("LLL", 0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            basketTryException.addProduct(new DiscountedProduct("ДДД", 12, 120));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            basketTryException.addProduct(new DiscountedProduct("ДДД", 12, -12));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            basketTryException.addProduct(new DiscountedProduct(null, 12, 120));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(searchEngine.getBestMatchSearchTerm("рв"));
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(searchEngine.getBestMatchSearchTerm("те"));
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}