package lottogame.exceptions;

@SuppressWarnings("serial")
public class NotEnoughMoneyException extends IllegalArgumentException {
    private static final String MESSAGE = "금액은 최소 %d 이상이어야 합니다. (입력값: \"%d\")";

    public NotEnoughMoneyException(int input, int minimumMoney) {
        super(String.format(MESSAGE, minimumMoney, input));
    }
}
