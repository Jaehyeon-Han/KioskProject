package hello.util;

import java.util.Optional;

public class IndexValidator {
    // 0-max -> Optional(value), else -> Optional.empty()
    public static Optional<Integer> getIntegerIndexFromChar(char input, int max) {
        try {
            int index = Integer.parseInt(String.valueOf(input));
            if (index > max || index < 0) {
                return Optional.empty();
            }

            return Optional.of(index);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
