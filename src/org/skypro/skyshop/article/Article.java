package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
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
    public String searchRequest() {
        return toString() + "\nТип - ARTICLE\n";
    }

    @Override
    public String typeContent() {
        return "ARTICLE\n";
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
}
