package hello.init;

import hello.model.Category;
import hello.model.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Init {
    public static List<Category> initCategories() {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("./src/main/resources/menu.data")))) {
            List<Category> categories = new ArrayList<>();

            String currentCategory = null;
            String line;
            while ((line = br.readLine()) != null) {
                currentCategory = line;

                List<Item> items = new ArrayList<>();
                while ((line = br.readLine()) != null && !line.isEmpty()) {
                    String pattern = "\"([^\"]+)\",([0-9.]+),\"([^\"]+)\"";
                    Pattern r = Pattern.compile(pattern);
                    Matcher m = r.matcher(line);

                    if (m.find()) {
                        String name = m.group(1);
                        double price = Double.parseDouble(m.group(2));
                        String description = m.group(3);

                        Item item = new Item(name, price, description);
                        items.add(item);
                    }
                }

                Category category = new Category(items, currentCategory);
                categories.add(category);
            }

            return categories;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Failed to initialize menu");
        }
    }
}
