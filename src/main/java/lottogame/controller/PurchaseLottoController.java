package lottogame.controller;

import lottogame.domain.Lotto;
import lottogame.domain.LottoMachine;
import lottogame.domain.PurchasedLotto;
import lottogame.exceptions.NotEnoughMoneyException;
import lottogame.utils.ParsingUtils;
import lottogame.view.InputView;
import lottogame.view.OutputView;

public class PurchaseLottoController {
    public static PurchasedLotto purchaseLotto() {
        try {
            return tryToPurchaseLotto();
        } catch (Exception e) {
            OutputView.printError(e);
            return purchaseLotto();       
        }
    }
    
    private static PurchasedLotto tryToPurchaseLotto() {
        OutputView.requestInputMoney();
        int inputMoney = ParsingUtils.stringToInteger(InputView.getInput());
        int purchasedLottoCount = getPurchasedLottoCount(inputMoney);
        OutputView.printPurchasedLottoCount(purchasedLottoCount);

        PurchasedLotto purchasedLotto = IssueLotto(purchasedLottoCount);
        OutputView.printPurchasedLotto(purchasedLotto);
        return purchasedLotto;
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
