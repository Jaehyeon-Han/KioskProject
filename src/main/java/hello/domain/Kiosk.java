package hello.domain;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menus;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        char category;
        do {
            printMainMenu();

            category = sc.nextLine().charAt(0);
            if(category == '0') break;
            Optional<Integer> optionalCategoryIndex = getValidIndex(category, menus.size());
            if(optionalCategoryIndex.isEmpty()) {
                System.out.println("잘못된 카테고리");
                continue;
            }

            Menu selectedMenu = menus.get(optionalCategoryIndex.get() - 1);
            char item;
            Optional<Integer> optionalItemIndex;
            do {
                selectedMenu.printMenu();
                System.out.println("0. 뒤로가기");

                item = sc.nextLine().charAt(0);
                if(item == '0') break;
                optionalItemIndex = getValidIndex(item, selectedMenu.getMenuItemSize());
                if(optionalItemIndex.isEmpty()) {
                    System.out.println("잘못된 메뉴");
                    continue;
                }
                System.out.println("선택한 메뉴: " + selectedMenu.getMenuItem(optionalItemIndex.get() - 1));
            } while (optionalItemIndex.isEmpty());
        } while (true);
    }

    // 0-max -> Optional(value), else -> Optional.empty()
    private Optional<Integer> getValidIndex(char input, int max) {
        try {
            int index = Integer.parseInt(String.valueOf(input));
            if (index > max || index < 0) {
                return Optional.empty();
            }

            return Optional.of(index);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    private void printMainMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); ++i) {
            System.out.println((i+1) + ". " + menus.get(i).getName());
        }
        System.out.println("0. 종료");
    }
}
