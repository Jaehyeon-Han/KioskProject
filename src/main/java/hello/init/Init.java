package hello.init;

import hello.domain.Menu;
import hello.domain.MenuItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Init {
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
