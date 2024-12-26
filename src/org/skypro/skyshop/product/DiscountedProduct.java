package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int defaultPrice;
    private int discount;
    public DiscountedProduct(String name, int defaultPrice, int discount) {
        super(name);
        this.defaultPrice = defaultPrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return defaultPrice - (defaultPrice * discount / 100);
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
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
