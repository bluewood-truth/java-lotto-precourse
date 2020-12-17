package lottogame.controller;

public class LottoGameController {
    public static void run() {
        PurchaseLottoController.purchaseLotto();
        WinningNumberController.inputWinningNumbers();
        LottoResultController.calculateWinning();
    }
}
