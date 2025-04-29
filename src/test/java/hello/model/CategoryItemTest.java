package hello.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryItemTest {

    @Test
    void testToString() {
        Item shackBurger = new Item("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        Item smokeShack = new Item("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        Item cheeseBurger = new Item("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        Item hamburger = new Item("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        String shackBurgerExpected = "ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거";
        String smokeShackExpected = "SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거";
        String cheeseBurgerExpected = "Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거";
        String hamBurgerExpected = "Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거";

        assertEquals(shackBurgerExpected, shackBurger.toString());
        assertEquals(smokeShackExpected, smokeShack.toString());
        assertEquals(cheeseBurgerExpected, cheeseBurger.toString());
        assertEquals(hamBurgerExpected, hamburger.toString());
    }
}