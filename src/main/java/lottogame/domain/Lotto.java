package lottogame.domain;

import java.util.Collections;
import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    public static final int PRICE = 1000;
    public static final int NUMBER_MINIMUM = 1;
    public static final int NUMBER_MAXIMUM = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        // TODO: numbers에 대한 예외처리
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
