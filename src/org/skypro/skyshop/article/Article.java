package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(tittle, article.tittle) && Objects.equals(text, article.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tittle, text);
    }
}
