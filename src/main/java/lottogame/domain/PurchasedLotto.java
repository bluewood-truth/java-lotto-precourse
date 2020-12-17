package lottogame.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLotto {
    private final List<Lotto> purchasedLotto = new ArrayList<>();

    public PurchasedLotto() {} 

    public void addLotto(Lotto lotto) {
        purchasedLotto.add(lotto);
    }
}
