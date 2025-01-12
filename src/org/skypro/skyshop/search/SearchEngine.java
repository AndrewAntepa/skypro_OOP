package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFoundException;

public class SearchEngine {
    Searchable[] searchables;
    int count = 0;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
    }

    public Searchable[] search(String searchTerm) {
        Searchable [] results = new Searchable[5];
        int countResults = 0;
        for (int i = 0; i < count; i++) {
            if (searchables[i].getSearchTerm().contains(searchTerm)) {
                results[countResults++] = searchables[i];
            }
            if(countResults == 5) break;
        }
        return results;
    }

    public void add(Searchable searchable) {
        searchables[count++] = searchable;
    }

    public Searchable getBestMatchSearchTerm(String search) throws BestResultNotFoundException {
        Searchable bestMatch = null;
        int bestCount = 0;

        for (Searchable searchable : searchables) {
            int newCount = countSubstrings(searchable.toString(), search);
            if (newCount > bestCount) {
                bestCount = newCount;
                bestMatch = searchable;
            }
        }

        if(bestMatch == null) throw new BestResultNotFoundException("Для " + search + " запроса не нашлось подходящей статьи");
        return bestMatch;
    }

    private int countSubstrings(String str, String subStr) {
        if (str == null || subStr == null || subStr.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;
        int subIndex = str.indexOf(subStr, index);

        while(subIndex != -1){
            count++;
            index = index + subStr.length();
            subIndex = str.indexOf(subStr, index);
        }

        return count;
    }
}
