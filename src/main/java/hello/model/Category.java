package hello.model;

import java.util.List;

public class Category {
    private final List<Item> items;
    private final String name;

    public Category(List<Item> items, String name) {
        this.items = items;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printItemsInCategory() {
        System.out.printf("[ %s MENU ]\n", name);
        for (int i = 0; i < items.size(); ++i) {
            System.out.println((i+1) + ". " + items.get(i).toString());
        }
    }

    public int getSize() {
        return items.size();
    }

    // index should be validated in advance
    public Item getItem(int index) {
        return items.get(index);
    }
}
