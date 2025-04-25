package hello.init;

import hello.domain.Menu;
import hello.domain.MenuItem;

import java.util.List;

public class Init {
    private static List<MenuItem> initBurgerMenu() {
        MenuItem shackBurger = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem smokeShack = new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem cheeseBurger = new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem hamburger = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        return List.of(shackBurger, smokeShack, cheeseBurger, hamburger);
    }

    public static List<Menu> initMenus() {
        Menu burgerMenu = new Menu(initBurgerMenu(), "BURGERS");
        Menu drinkMenu = new Menu(List.of(), "DRINKS");
        Menu dessertsMenu = new Menu(List.of(), "DESSERTS");

        return List.of(burgerMenu, drinkMenu, dessertsMenu);
    }
}
