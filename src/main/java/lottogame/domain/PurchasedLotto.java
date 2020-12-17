package lottogame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PurchasedLotto implements Iterable<Lotto> {
    private final List<Lotto> purchasedLotto = new ArrayList<>();

    public PurchasedLotto() {
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(purchasedLotto);
    }

    public void addLotto(Lotto lotto) {
        purchasedLotto.add(lotto);
    }

    @Override
    public Iterator<Lotto> iterator() {
        return purchasedLotto.iterator();
    }
}
