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
            if(category == '0') break; // 키오스크 종료

            // 제대로 된 입력을 받을 때까지 반복
            Optional<Integer> optionalCategoryNumber = getValidIndex(category, menus.size());
            if(optionalCategoryNumber.isEmpty()) {
                System.out.println("잘못된 카테고리");
                continue;
            }

            selectItemFromMenu(optionalCategoryNumber.get() - 1, sc);
        } while (true);
    }

    private void selectItemFromMenu(int categoryIndex, Scanner sc) {
        Menu selectedMenu = menus.get(categoryIndex);

        char item;
        Optional<Integer> optionalItemNumber;
        do {
            selectedMenu.printMenu();
            System.out.println("0. 뒤로가기");

            item = sc.nextLine().charAt(0);
            if(item == '0') break; // 메인 메뉴로

            // 제대로 된 입력을 받을 때까지 반복
            optionalItemNumber = getValidIndex(item, selectedMenu.getMenuItemSize());
            if(optionalItemNumber.isEmpty()) {
                System.out.println("잘못된 메뉴");
                continue;
            }
            
            System.out.println("선택한 메뉴: " + selectedMenu.getMenuItem(optionalItemNumber.get() - 1));
        } while (optionalItemNumber.isEmpty());
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
