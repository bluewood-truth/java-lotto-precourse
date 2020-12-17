package lottogame.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private static PurchasedLotto purchasedLotto;
    private static WinningLotto winningLoto;
    private static Map<Rank, Integer> winningCount = new HashMap<>();
    private static int winningMoney = 0;

    static {
        for(Rank rank : Arrays.asList((Rank.values()))){
            winningCount.put(rank, 0);
        }
    }

    public static void setPurchasedLotto(PurchasedLotto purchasedLotto) {
        LottoGame.purchasedLotto = purchasedLotto;
    }

    public static List<Lotto> getPerchasedLottoList() {
        return purchasedLotto.getLottoList();
    }
    
    public static void setWinningLotto(WinningLotto winningLotto) {
        LottoGame.winningLoto = winningLotto;
    }

    public static WinningLotto getWinningLotto() {
        return winningLoto;
    }

    public static void addWinningCount(Rank rank) {
        winningCount.put(rank, winningCount.get(rank) + 1);
    }

    public static int getWinningCount(Rank rank) {
        return winningCount.get(rank);
    }

    public static void addWinningMoney(int money) {
        winningMoney += money;
    }

    public static int getWinningMoney() {
        return winningMoney;
    }
    
    public static int getPerchasedMoney() {
        return getPerchasedLottoList().size() * Lotto.PRICE;
    }
}
