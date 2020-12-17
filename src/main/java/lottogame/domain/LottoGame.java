package lottogame.domain;

import java.util.Map;

public class LottoGame {
    private static PurchasedLotto purchasedLotto;
    private static WinningLotto winningLoto;
    private static Map<Rank, Integer> winningCount;

    public static void setPurchasedLotto(PurchasedLotto purchasedLotto) {
        LottoGame.purchasedLotto = purchasedLotto;
    }
    
    public static void setWinningLotto(WinningLotto winningLotto) {
        LottoGame.winningLoto = winningLotto;
    }
}
