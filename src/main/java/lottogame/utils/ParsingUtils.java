package lottogame.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lottogame.exceptions.CannotParseToIntegerException;

public class ParsingUtils {
    private static final String SPLITER = ",";

    public static int stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new CannotParseToIntegerException(input);
        }
    }

    public static List<Integer> stringToIntegerList(String input) {
        String[] splittedInput = split(input);
        return stringArrayToIntegerList(splittedInput);
    }

    private static String[] split(String input) {
        //TODO: split한 배열의 길이에 대한 예외처리

        return input.split(SPLITER);
    }
    
    private static List<Integer> stringArrayToIntegerList(String[] array) {
        List<Integer> integerList = new ArrayList<>();
        for (String string : Arrays.asList(array)) {
            integerList.add(stringToInteger(string));
        }

        return integerList;
    }
}
