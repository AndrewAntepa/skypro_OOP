package org.skypro.skyshop.search;

public interface Searchable {
    String searchRequest();

    String typeContent();

    default String getStringRepresentation(){
        return "Searchable - Searchable\n";
    }
}
