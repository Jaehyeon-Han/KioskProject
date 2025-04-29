package hello.state;

import hello.model.Category;
import hello.store.ItemStore;
import hello.util.InputHandler;

import java.util.Optional;

public class CategoryChosenState implements State {
    private final ItemStore itemStore;
    private final InputHandler inputHandler;
    private final Category chosenCategory;

    public CategoryChosenState(ItemStore itemStore, InputHandler inputHandler, int userInput) {
        this.itemStore = itemStore;
        this.inputHandler = inputHandler;
        this.chosenCategory = itemStore.getCategory(userInput - 1);
    }

    @Override
    public void printOptions() {
        chosenCategory.printItemsInCategory();
        System.out.println("0. 뒤로가기");
    }

    @Override
    public int getUserInput() {
        int itemCount = chosenCategory.getSize();
        return inputHandler.getIntegerInRange(0, itemCount);
    }

    @Override
    public Optional<State> processInput(int userInput) {
        if (userInput > 0) {
            System.out.println(chosenCategory.getItem(userInput - 1));
        }

        return Optional.of(new DefaultState(itemStore, inputHandler));
    }
}
