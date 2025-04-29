package hello.util;

import java.io.InputStream;
import java.util.Scanner;

public class InputHandler {
    private Scanner sc;

    public InputHandler(InputStream is) {
        this.sc = new Scanner(is);
    }

    public int getIntegerInRange(int min, int max) {
        String input;
        int number;
        while(true) {
            input = sc.nextLine();
            try {
                number = Integer.parseInt(input);
                if(min <= number && number <= max) {
                    return number;
                }
                System.out.println("Invalid range. Try again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }
}
