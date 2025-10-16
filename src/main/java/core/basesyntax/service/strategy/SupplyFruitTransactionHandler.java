package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyFruitTransactionHandler implements FruitTransactionHandler {
    private final Storage storage;

    public SupplyFruitTransactionHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        storage.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
