package lottogame.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lottogame.domain.Lotto;
import lottogame.exceptions.CannotParseToIntegerException;
import lottogame.exceptions.InvalidLottoNumberLengthException;

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
        String[] splittedInput = input.split(SPLITER);
        if (splittedInput.length != Lotto.NUMBER_LENGTH) {
            throw new InvalidLottoNumberLengthException();
        }

        return splittedInput;
    }
    
    private static List<Integer> stringArrayToIntegerList(String[] array) {
        List<Integer> integerList = new ArrayList<>();
        for (String string : Arrays.asList(array)) {
            integerList.add(stringToInteger(string));
        }

        return integerList;
    }

    public static int booleanToInt(boolean bool){
        if (bool) {
            return 1;
        }

        return 0;
    }
}
