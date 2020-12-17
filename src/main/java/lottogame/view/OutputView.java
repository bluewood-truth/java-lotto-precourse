package lottogame.view;

public class OutputView {
    public static final String ERROR_FORMAT = "[ERROR] %s%n";

    public static final String REQUEST_INPUT_MONEY = "구입금액을 입력해주세요.";

    public static void requestInputMoney() {
        System.out.println(REQUEST_INPUT_MONEY);
    }

    public static void printError(Exception e) {
        printEmptyLine();
        System.out.printf(ERROR_FORMAT, e.getMessage());
        printEmptyLine();
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
