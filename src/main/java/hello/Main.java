package hello;

import hello.domain.Kiosk;
import hello.domain.Menu;

import java.util.List;

import static hello.init.Init.initMenus;

public class Main {
    public static void main(String[] args) {
        List<Menu> menus = initMenus();

        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}