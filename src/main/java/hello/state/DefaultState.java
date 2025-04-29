package hello.state;

import hello.model.Category;
import hello.store.ItemStore;
import hello.util.InputHandler;

import java.util.List;
import java.util.Optional;

public class DefaultState implements State {
    private final ItemStore itemStore;
    private final InputHandler inputHandler;

    public DefaultState(ItemStore itemStore, InputHandler inputHandler) {
        this.itemStore = itemStore;
        this.inputHandler = inputHandler;
    }

    @Override
    public void printOptions() {
        List<Category> categories = itemStore.getCategories();

        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < categories.size(); ++i) {
            System.out.println((i + 1) + ". " + categories.get(i).getName());
        }
        // Cart가 비어있지 않으면 -> 추가 메뉴 출력
        System.out.println("0. 종료");
    }

    @Override
    public int getUserInput() {
        int categorySize = itemStore.getCategories().size();

        return inputHandler.getIntegerInRange(0, categorySize);
    }

    @Override
    public Optional<State> processInput(int userInput) {
        if (userInput == 0) {
            return Optional.empty();
        }

        return Optional.of(new CategoryChosenState(itemStore, inputHandler, userInput));
    }
}
