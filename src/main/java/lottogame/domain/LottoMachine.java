package lottogame.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_NUMBER_MINIMUM = 1;
    private static final int LOTTO_NUMBER_MAXIMUM = 45;
    private static final int LOTTO_NUMBER_LENGTH = 6;

    private static final List<Integer> machineNumbers = new ArrayList<>();
    
    public static List<Integer> getLottoNumbers() {
        resetMachineNumbers();
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_LENGTH; i++) {
            lottoNumbers.add(getLottoNumber());
        }
        return lottoNumbers;
    }
    
    private static int getLottoNumber() {
        // TODO: 로또머신에서 무작위로 숫자를 뽑아 반환하는 로직 구현
        return 0;
    }

    private static void resetMachineNumbers() {
        machineNumbers.clear();
        for (int i = LOTTO_NUMBER_MINIMUM; i <= LOTTO_NUMBER_MAXIMUM; i++) {
            machineNumbers.add(i);
        }
    }
}
