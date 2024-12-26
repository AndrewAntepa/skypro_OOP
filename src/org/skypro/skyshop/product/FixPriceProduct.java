package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    private static final int FIX_PRICE = 300;
    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIX_PRICE ;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String searchTerm() {
        return toString() + " - " + typeContent();
    }

    @Override
    public String typeContent() {
        return "PRODUCT";
    }

    @Override
    public String getStringRepresentation() {
        return getName() + " - " + typeContent();
    }
}
