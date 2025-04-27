package hello.state;

import hello.domain.Kiosk;

public class StateFactory {
    private final Kiosk context;

    public StateFactory(Kiosk context) {
        this.context = context;
    }

    public KioskState createHomeState() {
        return new HomeState(context.getMenus());
    }

    public KioskState createChooseMenuItemState(int selectedMenuIndex) {
        return new ChooseMenuItemState(context.getMenus().get(selectedMenuIndex));
    }
}
