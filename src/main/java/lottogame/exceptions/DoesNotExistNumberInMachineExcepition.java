package lottogame.exceptions;

@SuppressWarnings("serial")
public class DoesNotExistNumberInMachineExcepition extends IllegalArgumentException {
    private static final String MESSAGE = "같은 번호를 여러 번 뽑을 수 없습니다. (입력값: \"%d\")";

    public DoesNotExistNumberInMachineExcepition(int input) {
        super(String.format(MESSAGE, input));
    }
}
