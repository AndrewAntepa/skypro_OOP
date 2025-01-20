package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable{
    private String name;


    public Product(String name) {
        try{
            if(name.isBlank()) throw new IllegalArgumentException("Имя не может быть пустой строкой");
        } catch (NullPointerException e){
            throw new IllegalArgumentException("Имя не может быть пустой строкой");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();
    public abstract String toString();
    public abstract boolean isSpecial();

    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }

    @Override
    public String getSearchTerm() {
        return getName() + " - " + getTypeContent();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
