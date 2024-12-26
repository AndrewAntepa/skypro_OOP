package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private String name;


    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();
    public abstract String toString();
    public abstract boolean isSpecial();
}
