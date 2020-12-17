package lottogame.controller;

import java.util.List;

import lottogame.domain.Lotto;
import lottogame.domain.LottoGame;
import lottogame.domain.Rank;
import lottogame.domain.WinningLotto;
import lottogame.view.OutputView;

public class LottoResultController {
    public static void calculateWinning() {
        List<Lotto> purchasedLotto = LottoGame.getPerchasedLottoList();
        WinningLotto winningLotto = LottoGame.getWinningLotto();

        for (Lotto lotto : purchasedLotto) {
            addWinningValues(winningLotto.match(lotto));
        }

        OutputView.printWinningResult();
        OutputView.printLottoYield(getLottoYieldPercentage());
    }

    private static void addWinningValues(Rank rank) {
        LottoGame.addWinningCount(rank);
        LottoGame.addWinningMoney(rank.getWinningMoney());
    }

    private static float getLottoYieldPercentage() {
        return (float)(LottoGame.getWinningMoney() / LottoGame.getPerchasedMoney() * 100);
    }
}
