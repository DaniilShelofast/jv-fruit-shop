package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceFruitTransactionHandler implements FruitTransactionHandler {
    private final Storage storage;

    public BalanceFruitTransactionHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        storage.set(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
