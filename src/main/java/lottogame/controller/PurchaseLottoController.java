package lottogame.controller;

import lottogame.domain.Lotto;
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
        int inputMoney = ParsingUtils.stringToInteger(InputView.getInput());
        int countOfLottoToPurchase = getCountOfLottoToPurchase(inputMoney);
    }

    private static int getCountOfLottoToPurchase(int inputMoney) {
        if (inputMoney < Lotto.PRICE) {
            throw new NotEnoughMoneyException(inputMoney, Lotto.PRICE);
        }
        
        return inputMoney / Lotto.PRICE;
    }
}
