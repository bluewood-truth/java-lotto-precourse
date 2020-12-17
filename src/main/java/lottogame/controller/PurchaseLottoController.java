package lottogame.controller;

import lottogame.domain.Lotto;
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
        // TODO: 입력 금액이 로또 가격보다 낮을 경우 예외처리
        return inputMoney / Lotto.PRICE;
    }
}
