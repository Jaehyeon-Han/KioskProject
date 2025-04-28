package hello.init;

import hello.domain.Menu;
import hello.domain.MenuItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Init {
    private static List<MenuItem> initBurgerMenu() {
        MenuItem shackBurger = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem smokeShack = new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem cheeseBurger = new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem hamburger = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        return List.of(shackBurger, smokeShack, cheeseBurger, hamburger);
    }

    public static List<Menu> initMenus() {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("./src/main/resources/menu.data")))) {
            List<Menu> menus = new ArrayList<>();

            String category = null;
            String line;
            while ((line = br.readLine()) != null) {
                category = line;

                List<MenuItem> menuItems = new ArrayList<>();
                while ((line = br.readLine()) != null && !line.isEmpty()) {
                    String pattern = "\"([^\"]+)\",([0-9.]+),\"([^\"]+)\"";
                    Pattern r = Pattern.compile(pattern);
                    Matcher m = r.matcher(line);

                    if (m.find()) {
                        String name = m.group(1);
                        double price = Double.parseDouble(m.group(2));
                        String description = m.group(3);

                        MenuItem menuItem = new MenuItem(name, price, description);
                        menuItems.add(menuItem);
                    }
                }

                Menu menu = new Menu(menuItems, category);
                menus.add(menu);
            }

            return menus;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Failed to initialize menu");
        }
    }
}
