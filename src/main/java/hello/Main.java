package hello;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char input;
        do {
            System.out.println("""
                    [ SHAKESHACK MENU ]
                    1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
                    2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
                    3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
                    4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
                    0. 종료      | 종료
                    """);
            input = sc.nextLine().charAt(0);
            switch(input) {
                case '0' -> System.out.println("Terminating...");
                case '1' -> System.out.println("Shaking");
                case '2' -> System.out.println("Smoking");
                case '3' -> System.out.println("Cheesy");
                case '4' -> System.out.println("Classic");
                default -> System.out.println("No food for you!");
            }
        } while (input != '0');
    }
}