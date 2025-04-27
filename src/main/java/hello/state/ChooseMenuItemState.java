package hello.state;

import hello.domain.Kiosk;
import hello.domain.Menu;

import java.util.Optional;
import java.util.Scanner;

import static hello.util.IndexValidator.getIntegerIndexFromChar;

public class ChooseMenuItemState implements KioskState {
    private final Menu selectedMenu;

    public ChooseMenuItemState(Menu selectedMenu) {
        this.selectedMenu = selectedMenu;
    }

    @Override
    public void execute(Kiosk context) {
        Scanner sc = new Scanner(System.in);
        char item;
        Optional<Integer> optionalItemIndex;
        do {
            selectedMenu.printMenu();
            System.out.println("0. 뒤로가기");

            item = sc.nextLine().charAt(0);
            if(item == '0') {
                setHomeState(context);
                return;
            }

            optionalItemIndex = getIntegerIndexFromChar(item, selectedMenu.getMenuItemSize());
            if(optionalItemIndex.isEmpty()) {
                System.out.println("잘못된 메뉴");
                continue;
            }
            System.out.println("선택한 메뉴: " + selectedMenu.getMenuItem(optionalItemIndex.get() - 1));

            setHomeState(context);
            return;
        } while (true);
    }

    private static void setHomeState(Kiosk context) {
        StateFactory stateFactory = new StateFactory(context);
        KioskState homeState = stateFactory.createHomeState();
        context.setState(homeState);
    }
}
