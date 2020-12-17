package lottogame.domain;

import java.util.Collections;
import java.util.List;

import lottogame.exceptions.InvalidLottoNumberException;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    public static final int PRICE = 1000;
    public static final int NUMBER_MINIMUM = 1;
    public static final int NUMBER_MAXIMUM = 45;
    public static final int NUMBER_LENGTH = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumber(number);
        }

        this.numbers = numbers;
    }

    private void validateNumber(int number) {
        if (number < NUMBER_MINIMUM || number > NUMBER_MAXIMUM) {
            throw new InvalidLottoNumberException(number, NUMBER_MINIMUM, NUMBER_MAXIMUM);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
