package hello.state;

import hello.domain.Kiosk;

import java.util.Optional;

import static hello.util.IndexValidator.getIntegerIndexFromChar;

public class ChooseMenuState implements KioskState {
    @Override
    public void execute(Kiosk context) {
        char item;
        Optional<Integer> optionalItemIndex;
        do {
            selectedMenu.printMenu();
            System.out.println("0. 뒤로가기");

            item = sc.nextLine().charAt(0);
            if(item == '0') break;
            optionalItemIndex = getIntegerIndexFromChar(item, selectedMenu.getMenuItemSize());
            if(optionalItemIndex.isEmpty()) {
                System.out.println("잘못된 메뉴");
                continue;
            }
            System.out.println("선택한 메뉴: " + selectedMenu.getMenuItem(optionalItemIndex.get() - 1));
        } while (optionalItemIndex.isEmpty());
    }
}
