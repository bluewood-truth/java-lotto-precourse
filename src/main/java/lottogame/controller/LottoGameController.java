package lottogame.controller;

import lottogame.domain.LottoGame;

public class LottoGameController {
    public static void run() {
        LottoGame lottoGame = new LottoGame();
        lottoGame.setPurchasedLotto(PurchaseLottoController.purchaseLotto());
        lottoGame.setWinningLotto(WinningNumberController.inputWinningNumbers());;
        LottoResultController.calculateResult(lottoGame);
    }
}
