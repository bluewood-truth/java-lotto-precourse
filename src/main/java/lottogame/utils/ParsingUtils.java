package lottogame.utils;

import lottogame.exceptions.CannotParseToIntegerException;

public class ParsingUtils {
    public static int stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new CannotParseToIntegerException(input);
        }
    }
}
