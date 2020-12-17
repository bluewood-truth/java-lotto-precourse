package lottogame.controller;

import java.util.List;

import lottogame.domain.Lotto;
import lottogame.utils.ParsingUtils;
import lottogame.view.InputView;
import lottogame.view.OutputView;

public class WinningNumberController {
    public static void inputWinningNumbers() {
        try {
            tryToInputWinningNumbers();
        } catch (Exception e) {
            OutputView.printError(e);
            inputWinningNumbers();
        }
    }

    private static void tryToInputWinningNumbers() {
        Lotto lotto = getInputLotto();
    }
    
    private static Lotto getInputLotto() {
        OutputView.requestWinningNumbers();
        List<Integer> inputNumbers = ParsingUtils.stringToIntegerList(InputView.getInput());
        return new Lotto(inputNumbers);
    }
}
