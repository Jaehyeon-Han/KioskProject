package hello;

import hello.domain.Kiosk;
import hello.domain.MenuItem;

import java.util.List;

import static hello.init.Init.initMenuItems;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = initMenuItems();
        Kiosk kiosk = new Kiosk(menuItems);
        kiosk.start();
    }
}