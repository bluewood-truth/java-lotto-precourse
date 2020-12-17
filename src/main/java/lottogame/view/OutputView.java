package lottogame.view;

public class OutputView {
    public static final String ERROR_FORMAT = "[ERROR] %s%n";

    public static void printError(Exception e) {
        System.out.printf(ERROR_FORMAT, e.getMessage());
    }
}
