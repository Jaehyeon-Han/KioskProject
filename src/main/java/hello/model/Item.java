package hello.model;

import java.util.Objects;

public class Item {
    private final String name;
    private final double price;
    private final String description;

    public Item(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(price, item.price) == 0 && Objects.equals(name, item.name) && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, description);
    }

    @Override
    public String toString() {
        return String.format("%-13s | W %01.1f | %s", name, price, description);
    }
}
