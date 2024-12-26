package org.skypro.skyshop.product;

public class SimpleProduct extends Product{
    private int price;
    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
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
