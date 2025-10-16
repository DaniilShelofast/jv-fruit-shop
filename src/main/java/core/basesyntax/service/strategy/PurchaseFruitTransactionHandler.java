package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseFruitTransactionHandler implements FruitTransactionHandler {
    private final Storage storage;

    public PurchaseFruitTransactionHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        storage.delete(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
