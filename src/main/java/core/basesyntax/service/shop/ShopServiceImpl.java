package core.basesyntax.service.shop;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.FruitTransactionStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final FruitTransactionStrategy fruitTransactionStrategy;

    public ShopServiceImpl(FruitTransactionStrategy fruitTransactionStrategy) {
        if (fruitTransactionStrategy == null) {
            throw new RuntimeException("FruitTransactionStrategy must not be null");
        }
        this.fruitTransactionStrategy = fruitTransactionStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        if (fruitTransactions == null) {
            throw new RuntimeException("Parameters should not be null");
        }
        if (fruitTransactions.isEmpty()) {
            throw new RuntimeException("Parameters should not be empty");
        }
        for (FruitTransaction f : fruitTransactions) {
            if (f != null) {
                fruitTransactionStrategy.get(f.getOperation()).handler(f);
            } else {
                throw new RuntimeException("Element should not be null");
            }
        }
    }
}

