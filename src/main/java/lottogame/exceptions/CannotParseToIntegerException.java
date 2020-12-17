package lottogame.exceptions;

@SuppressWarnings("serial")
public class CannotParseToIntegerException extends IllegalArgumentException {
    private static final String MESSAGE = "올바른 정수값이 아닙니다. (입력값: \"%s\")";

    public CannotParseToIntegerException(String input) {
        super(String.format(MESSAGE, input));
    }
}
