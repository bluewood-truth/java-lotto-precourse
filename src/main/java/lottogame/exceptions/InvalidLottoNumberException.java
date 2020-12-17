package lottogame.exceptions;

@SuppressWarnings("serial")
public class InvalidLottoNumberException extends IllegalArgumentException {
    private static final String MESSAGE = "로또번호는 %d~%d 중 하나여야 합니다. (입력값: \"%d\")";

    public InvalidLottoNumberException(int input, int minimumNumber, int maximumNumber) {
        super(String.format(MESSAGE, minimumNumber, maximumNumber, input));
    }
}
