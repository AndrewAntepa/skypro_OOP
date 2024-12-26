package org.skypro.skyshop.search;

public interface Searchable {
    String searchTerm();

    String typeContent();

    default String getStringRepresentation(){
        return "Searchable - Searchable\n";
    }
}
