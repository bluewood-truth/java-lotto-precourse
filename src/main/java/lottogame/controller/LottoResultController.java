package lottogame.controller;

import java.util.List;

import lottogame.domain.Lotto;
import lottogame.domain.LottoGame;
import lottogame.domain.Rank;
import lottogame.domain.WinningLotto;
import lottogame.view.OutputView;

public class LottoResultController {
    public static void calculateWinning() {
        try {
            tryToCalculateWinning();
        } catch (Exception e) {
            OutputView.printError(e);
            calculateWinning();
        }
    }

    public static void tryToCalculateWinning() {
        List<Lotto> purchasedLotto = LottoGame.getPerchasedLottoList();
        WinningLotto winningLotto = LottoGame.getWinningLotto();

        for (Lotto lotto : purchasedLotto) {
            addWinningValues(winningLotto.match(lotto));
        }

        OutputView.printWinningResult();
    }
    
    private static void addWinningValues(Rank rank) {
        LottoGame.addWinningCount(rank);
        LottoGame.addWinningMoney(rank.getWinningMoney());
    }
}
