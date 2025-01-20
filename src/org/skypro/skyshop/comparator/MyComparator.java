package org.skypro.skyshop.comparator;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.search.Searchable;

import java.util.Comparator;

public class MyComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        if(o1.getStringRepresentation().length() != o2.getStringRepresentation().length())
            return Integer.compare(o2.getStringRepresentation().length(), o1.getStringRepresentation().length());
        return o2.getStringRepresentation().compareTo(o1.getStringRepresentation());
    }
}
