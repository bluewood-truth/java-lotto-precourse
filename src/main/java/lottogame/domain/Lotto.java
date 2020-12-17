package lottogame.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import lottogame.exceptions.InvalidLottoNumberException;
import lottogame.utils.ParsingUtils;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto implements Iterable<Integer> {
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

    public int getMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            matchCount += ParsingUtils.booleanToInt(contains(number));
        }
        return matchCount;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }
}
