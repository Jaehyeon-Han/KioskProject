package hello.state;

import hello.domain.Kiosk;
import hello.domain.Menu;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static hello.util.IndexValidator.getIntegerIndexFromChar;

public class HomeState implements KioskState {
    private final List<Menu> menus;

    public HomeState(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public void execute(Kiosk context) {
        Scanner sc = new Scanner(System.in);

        char category;
        do {
            printMainMenu();

            category = sc.nextLine().charAt(0);
            if(category == '0') {
                context.setState(null);
                return;
            }
            Optional<Integer> optionalCategoryIndex = getIntegerIndexFromChar(category, menus.size());
            if(optionalCategoryIndex.isEmpty()) {
                System.out.println("잘못된 카테고리");
                continue;
            }

            StateFactory stateFactory = new StateFactory(context);
            KioskState chooseMenuItemState = stateFactory.createChooseMenuItemState(optionalCategoryIndex.get() - 1);
            context.setState(chooseMenuItemState);
            return;
        } while (true);
    }

    private void printMainMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); ++i) {
            System.out.println((i+1) + ". " + menus.get(i).getName());
        }
        System.out.println("0. 종료");
    }
}
