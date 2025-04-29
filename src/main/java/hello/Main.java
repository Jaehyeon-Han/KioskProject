package hello;

import hello.model.Category;
import hello.state.DefaultState;
import hello.store.ItemStore;
import hello.util.InputHandler;

import java.util.List;

import static hello.init.Init.initCategories;

public class Main {
    public static void main(String[] args) {
        List<Category> categories = initCategories();
        ItemStore itemStore = new ItemStore(categories);

        InputHandler inputHandler = new InputHandler(System.in);

        DefaultState defaultState = new DefaultState(itemStore, inputHandler);

        Kiosk kiosk = new Kiosk(defaultState);

        kiosk.start();
    }
}