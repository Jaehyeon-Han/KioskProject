package hello.store;

import hello.model.Category;

import java.util.List;

public class ItemStore {
    private final List<Category> categories;

    public ItemStore(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories.stream().toList();
    }

    public Category getCategory (int index) {
        return categories.get(index);
    }
}
