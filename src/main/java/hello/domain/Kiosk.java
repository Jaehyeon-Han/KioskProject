package hello.domain;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        char input;

        do {
            printMenu();
            input = sc.nextLine().charAt(0);
            processInput(input);
        } while (input != '0');
    }

    private void processInput(char input) {
        switch(input) {
            case '0' -> System.out.println("Terminating...");
            case '1' -> System.out.println("Shaking");
            case '2' -> System.out.println("Smoking");
            case '3' -> System.out.println("Cheesy");
            case '4' -> System.out.println("Classic");
            default -> System.out.println("No food for you!");
        }
    }

    private void printMenu() {
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuItems.size(); ++i) {
            System.out.println((i+1) + ". " + menuItems.get(i).toString());
        }
        System.out.println("0. 종료      | 종료");
    }
}
