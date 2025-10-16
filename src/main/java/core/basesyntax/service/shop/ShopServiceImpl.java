package core.basesyntax.service.shop;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.FruitTransactionStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final FruitTransactionStrategy fruitTransactionStrategy;

    public ShopServiceImpl(FruitTransactionStrategy fruitTransactionStrategy) {
        this.fruitTransactionStrategy = fruitTransactionStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction f : fruitTransactions) {
            fruitTransactionStrategy.get(f.getOperation()).handler(f);
        }
    }
}

