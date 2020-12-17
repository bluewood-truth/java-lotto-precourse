package lottogame.controller;

import java.util.List;
import lottogame.domain.Lotto;
import lottogame.domain.LottoMachine;
import lottogame.domain.WinningLotto;
import lottogame.utils.ParsingUtils;
import lottogame.view.InputView;
import lottogame.view.OutputView;

public class WinningNumberController {
    public static WinningLotto inputWinningNumbers() {
        try {
            return tryToInputWinningNumbers();
        } catch (Exception e) {
            OutputView.printError(e);
            return inputWinningNumbers();
        }
    }

    private static WinningLotto tryToInputWinningNumbers() {
        Lotto lotto = getInputLotto();
        int bonusNumber = getInputBonusNumber();
        return new WinningLotto(lotto, bonusNumber);
    }
    
    private static Lotto getInputLotto() {
        OutputView.requestWinningNumbers();
        List<Integer> inputNumbers = ParsingUtils.stringToIntegerList(InputView.getInput());
        removeNumbersFromMachine(inputNumbers);
        return new Lotto(inputNumbers);
    }

    private static void removeNumbersFromMachine(List<Integer> inputNumbers) {
        LottoMachine.resetMachineNumbers();
        for (int number : inputNumbers) {
            LottoMachine.removeNumberFromMachine(number);
        }
    }

    private static int getInputBonusNumber() {
        OutputView.requestBonusNumber();
        int inputNumber = ParsingUtils.stringToInteger(InputView.getInput());
        LottoMachine.removeNumberFromMachine(inputNumber);
        return inputNumber;
    }
}
