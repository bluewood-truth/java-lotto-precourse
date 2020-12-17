package lottogame.controller;

import lottogame.domain.Lotto;
import lottogame.domain.LottoGame;
import lottogame.domain.Rank;
import lottogame.domain.WinningLotto;
import lottogame.view.OutputView;

public class LottoResultController {
    public static void calculateResult(LottoGame lottoGame) {
        WinningLotto winningLotto = lottoGame.getWinningLotto();
        for (Lotto lotto : lottoGame.getPerchasedLottoList()) {
            Rank rank = winningLotto.match(lotto);
            lottoGame.addWinningCount(rank);
            lottoGame.addWinningMoney(rank.getWinningMoney());
        }

        OutputView.printWinningResult(lottoGame, getLottoYieldPercentage(lottoGame));
    }

    private static float getLottoYieldPercentage(LottoGame lottoGame) {
        return (float)(lottoGame.getWinningMoney() / lottoGame.getPerchasedMoney() * 100);
    }
}
