package lottogame.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private PurchasedLotto purchasedLotto;
    private WinningLotto winningLoto;
    private Map<Rank, Integer> winningCount = new HashMap<>();
    private int winningMoney = 0;

    public LottoGame() {
        for (Rank rank : Arrays.asList((Rank.values()))) {
            winningCount.put(rank, 0);
        }
    }

    public void setPurchasedLotto(PurchasedLotto purchasedLotto) {
        this.purchasedLotto = purchasedLotto;
    }

    public List<Lotto> getPerchasedLottoList() {
        return purchasedLotto.getLottoList();
    }
    
    public void setWinningLotto(WinningLotto winningLotto) {
        this.winningLoto = winningLotto;
    }

    public WinningLotto getWinningLotto() {
        return winningLoto;
    }

    public void addWinningCount(Rank rank) {
        winningCount.put(rank, winningCount.get(rank) + 1);
    }

    public int getWinningCount(Rank rank) {
        return winningCount.get(rank);
    }

    public void addWinningMoney(int money) {
        winningMoney += money;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
    
    public int getPerchasedMoney() {
        return getPerchasedLottoList().size() * Lotto.PRICE;
    }
}
