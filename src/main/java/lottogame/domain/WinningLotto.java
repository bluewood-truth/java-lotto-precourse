package lottogame.domain;

import lottogame.exceptions.InvalidLottoNumberException;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        if (bonusNo < Lotto.NUMBER_MINIMUM || bonusNo > Lotto.NUMBER_MAXIMUM) {
            throw new InvalidLottoNumberException(bonusNo, Lotto.NUMBER_MINIMUM, Lotto.NUMBER_MAXIMUM);
        }

        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        // TODO 로직 구현
        return null;
    }
}
