package hello.domain;

import hello.state.HomeState;
import hello.state.KioskState;
import hello.state.StateFactory;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menus;
    private KioskState state;

    public void setState(KioskState state) {
        this.state = state;
    }

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
        StateFactory stateFactory = new StateFactory(this);
        state = stateFactory.createHomeState();
    }

    public void start() {
        while (state != null) {
            state.execute(this);
        }
    }

    public List<Menu> getMenus() {
        return this.menus;
    }
}
