package hello.init;

import hello.domain.Menu;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class InitTest {

    @Test
    void initMenus() {
        List<Menu> menus = Init.initMenus();
        for (Menu menu : menus) {
            menu.printMenu();
        }
        assertFalse(menus.isEmpty());
    }

    @Test
    void readerTest() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("./src/main/resources/menu.data")));
            System.out.println(br.readLine());
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    void regexTest() {
        String line = "\"Hamburger\",5.4,\"비프패티를 기반으로 야채가 들어간 기본버거\"";
        String pattern = "\"([^\"]+)\",([0-9.]+),\"([^\"]+)\"";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);

        if (m.find()) {
            String name = m.group(1);  // 첫 번째 그룹: 이름
            double price = Double.parseDouble(m.group(2));  // 두 번째 그룹: 가격
            String description = m.group(3);  // 세 번째 그룹: 설명

            // 결과 출력
            System.out.println("Name: " + name);
            System.out.println("Price: " + price);
            System.out.println("Description: " + description);
        } else {
            System.out.println("No match found!");
        }
    }
}