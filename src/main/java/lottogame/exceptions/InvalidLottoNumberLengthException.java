package lottogame.exceptions;

@SuppressWarnings("serial")
public class InvalidLottoNumberLengthException extends IllegalArgumentException {
    private static final String MESSAGE = "6개의 로또번호를 ','로 구분하여 입력해주시기 바랍니다.";

    public InvalidLottoNumberLengthException() {
        super(MESSAGE);
    }
}
