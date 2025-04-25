package hello;

import hello.domain.MenuItem;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char input;
        List<MenuItem> menuItems = initMenuItems();

        do {
            printMenu(menuItems);

            input = sc.nextLine().charAt(0);
            processInput(input);
        } while (input != '0');
    }

    private static void processInput(char input) {
        switch(input) {
            case '0' -> System.out.println("Terminating...");
            case '1' -> System.out.println("Shaking");
            case '2' -> System.out.println("Smoking");
            case '3' -> System.out.println("Cheesy");
            case '4' -> System.out.println("Classic");
            default -> System.out.println("No food for you!");
        }
    }

    private static void printMenu(List<MenuItem> menuItems) {
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuItems.size(); ++i) {
            System.out.println((i+1) + ". " + menuItems.get(i).toString());
        }
        System.out.println("0. 종료      | 종료");
    }

    private static List<MenuItem> initMenuItems() {
        MenuItem shackBurger = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem smokeShack = new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem cheeseBurger = new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem hamburger = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        return List.of(shackBurger, smokeShack, cheeseBurger, hamburger);
    }
}