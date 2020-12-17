package lottogame.view;

import java.util.List;

import lottogame.domain.Lotto;
import lottogame.domain.LottoGame;
import lottogame.domain.PurchasedLotto;
import lottogame.domain.Rank;

public class OutputView {
    public static final String ERROR_FORMAT = "[ERROR] %s%n";
    public static final String LOTTO_FORMAT = "[%s]";

    public static final String REQUEST_INPUT_MONEY = "구입금액을 입력해주세요.";
    public static final String PURCHASED_LOTTO_COUNT = "%d개를 구입했습니다.%n";
    public static final String REQUEST_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해주세요.";
    public static final String REQUEST_BONUS_NUMBER = "보너스 볼을 입력해주세요.";

    public static final String WINNING_RESULT_TITLE = "당첨 통계\n--------";
    public static final String WINNING_RESULT_FORMAT = "%s - %d개%n";
    public static final String YIELD_FORMAT = "총 수익률은 %.00f%%입니다.";

    public static void requestInputMoney() { 
        System.out.println(REQUEST_INPUT_MONEY);
    }

    public static void printPurchasedLottoCount(int purchasedLottoCount) {
        printEmptyLine();
        System.out.printf(PURCHASED_LOTTO_COUNT, purchasedLottoCount);
    }

    public static void printPurchasedLotto(PurchasedLotto purchasedLotto) {
        for (Lotto lotto : purchasedLotto) {
            printNumbers(lotto.getNumbers());
        }

        printEmptyLine();
    }

    private static void printNumbers(List<Integer> numbers) {
        System.out.println(numbers.toString());
    }

    public static void requestWinningNumbers() {
        printEmptyLine();
        System.out.println(REQUEST_WINNING_NUMBERS);
    }

    public static void requestBonusNumber() {
        printEmptyLine();
        System.out.println(REQUEST_BONUS_NUMBER);
    }

    public static void printWinningResult() {
        printEmptyLine();
        System.out.println(WINNING_RESULT_TITLE);
        Rank[] ranks = Rank.values();
        for (int i = ranks.length - 1; i >= 0; i--) {
            printWinningRank(ranks[i]);
        }
    }

    private static void printWinningRank(Rank rank) {
        if (rank == Rank.MISS) {
            return;
        }

        System.out.printf(WINNING_RESULT_FORMAT, rank.toString(), LottoGame.getWinningCount(rank));
    }
    
    public static void printLottoYield(float lottoYield) {
        System.out.printf(YIELD_FORMAT, lottoYield);
    }

    public static void printError(Exception e) {
        printEmptyLine();
        System.out.printf(ERROR_FORMAT, e.getMessage());
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
