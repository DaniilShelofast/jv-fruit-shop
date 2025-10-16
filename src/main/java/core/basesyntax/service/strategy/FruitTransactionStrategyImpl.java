package core.basesyntax.service.strategy;

import core.basesyntax.model.Operation;
import java.util.Map;

public class FruitTransactionStrategyImpl implements FruitTransactionStrategy {
    private final Map<Operation, FruitTransactionHandler> map;

    public FruitTransactionStrategyImpl(Map<Operation, FruitTransactionHandler> map) {
        this.map = map;
    }

    @Override
    public FruitTransactionHandler get(Operation type) {
        return map.get(type);
    }
}
