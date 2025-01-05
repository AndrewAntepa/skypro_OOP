package org.skypro.skyshop.search;

public class SearchEngine {
    Searchable[] searchables;
    int count = 0;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
    }

    public String[] search(String searchTerm) {
        String [] results = new String[5];
        int countResults = 0;
        for (int i = 0; i < count; i++) {
            if (searchables[i].searchRequest().contains(searchTerm)) {
                results[countResults++] = searchables[i].getStringRepresentation();
            }
            if(countResults == 5) break;
        }
        return results;
    }

    public void add(Searchable searchable) {
        searchables[count++] = searchable;
    }
}
