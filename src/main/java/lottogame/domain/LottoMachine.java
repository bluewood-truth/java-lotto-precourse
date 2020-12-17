package lottogame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lottogame.utils.RandomUtils;

public class LottoMachine {
    private static final int LOTTO_NUMBER_LENGTH = 6;

    private static final List<Integer> machineNumbers = new ArrayList<>();
    
    public static List<Integer> getLottoNumbers() {
        resetMachineNumbers();
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_LENGTH; i++) {
            lottoNumbers.add(getLottoNumber());
        }

        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
    
    private static int getLottoNumber() {
        int number = getNumberFromMachine();
        removeNumberFromMachine(number);
        return number;
    }

    private static int getNumberFromMachine() {
        return machineNumbers.get(RandomUtils.nextInt(machineNumbers.size()));
    }
    
    private static void removeNumberFromMachine(int number) {
        machineNumbers.removeIf(machineNumber -> machineNumber == number);
    }

    private static void resetMachineNumbers() {
        machineNumbers.clear();
        for (int i = Lotto.NUMBER_MINIMUM; i <= Lotto.NUMBER_MAXIMUM; i++) {
            machineNumbers.add(i);
        }
    }
}
