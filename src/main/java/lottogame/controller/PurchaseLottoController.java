package lottogame.controller;

import lottogame.domain.Lotto;
import lottogame.domain.LottoGame;
import lottogame.domain.LottoMachine;
import lottogame.domain.PurchasedLotto;
import lottogame.exceptions.NotEnoughMoneyException;
import lottogame.utils.ParsingUtils;
import lottogame.view.InputView;
import lottogame.view.OutputView;

public class PurchaseLottoController {
    public static void purchaseLotto() {
        try {
            tryToPurchaseLotto();
        } catch (Exception e) {
            OutputView.printError(e);
            purchaseLotto();       
        }
    }
    
    private static void tryToPurchaseLotto() {
        OutputView.requestInputMoney();
        int inputMoney = ParsingUtils.stringToInteger(InputView.getInput());
        int purchasedLottoCount = getPurchasedLottoCount(inputMoney);
        OutputView.printPurchasedLottoCount(purchasedLottoCount);

        PurchasedLotto purchasedLotto = IssueLotto(purchasedLottoCount);
        OutputView.printPurchasedLotto(purchasedLotto);
        LottoGame.setPurchasedLotto(purchasedLotto);
    }

    private static int getPurchasedLottoCount(int inputMoney) {
        if (inputMoney < Lotto.PRICE) {
            throw new NotEnoughMoneyException(inputMoney, Lotto.PRICE);
        }

        return inputMoney / Lotto.PRICE;
    }

    private static PurchasedLotto IssueLotto(int purchasedLottoCount) {
        PurchasedLotto purchasedLotto = new PurchasedLotto();
        for (int i = 0; i < purchasedLottoCount; i++) {
            Lotto lotto = new Lotto(LottoMachine.getLottoNumbers());
            purchasedLotto.addLotto(lotto);
        }

        return purchasedLotto;
    }
}
