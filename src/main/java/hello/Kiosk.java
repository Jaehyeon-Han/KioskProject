package hello;

import hello.state.State;

import java.util.Optional;

public class Kiosk {
    private State state;

    public Kiosk(State state) {
        this.state = state;
    }

    public void start() {
        Optional<State> optionalState = Optional.of(state);
        while(optionalState.isPresent()) {
            state = optionalState.get();
            state.printOptions();
            int input = state.getUserInput();
            optionalState = state.processInput(input);
        }
    }

    public void setState(State state) {
        this.state = state;
    }
}
