package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public class Article implements Searchable, Comparable<Article> {
    private String tittle;
    private String text;

    public Article(String tittle, String text) {
        this.tittle = tittle;
        this.text = text;
    }

    @Override
    public String toString() {
        return tittle + '\n' + text;
    }

    @Override
    public String getSearchTerm() {
        return this + " " + getTypeContent();
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {
        return tittle + "\nТип - ARTICLE";
    }

    public String getTittle() {
        return tittle;
    }

    public String getText() {
        return text;
    }



    @Override
    public int compareTo(Article o) {
        if(tittle.length() != o.tittle.length()) return Integer.compare(o.tittle.length(), tittle.length());
        return o.tittle.compareTo(tittle);
    }
}
