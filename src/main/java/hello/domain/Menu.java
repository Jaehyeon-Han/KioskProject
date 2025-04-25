package hello.domain;

import java.util.List;


// 하나의 카테고리에 해당하는 메뉴
public class Menu {
    private final List<MenuItem> menuItems;
    private final String name;

    public Menu(List<MenuItem> menuItems, String name) {
        this.menuItems = menuItems;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void printMenu() {
        System.out.printf("[ %s MENU ]\n", name);
        for (int i = 0; i < menuItems.size(); ++i) {
            System.out.println((i+1) + ". " + menuItems.get(i).toString());
        }
    }

    public int getMenuItemSize() {
        return menuItems.size();
    }

    // index should be validated in advance
    public MenuItem getMenuItem(int index) {
        return menuItems.get(index);
    }
}
