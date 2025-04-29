package hello.state;

import java.util.Optional;

public interface State {
    void printOptions();
    int getUserInput();
    Optional<State> processInput(int userInput);
}
