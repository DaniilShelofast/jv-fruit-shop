package core.basesyntax.db;

import java.util.Map;

public class StorageImpl implements Storage {
    private final Map<String, Integer> map;

    public StorageImpl(Map<String, Integer> map) {
        this.map = map;
    }

    @Override
    public int getFruit(String fruit) {
        if (fruit == null || fruit.isBlank()) {
            throw new IllegalArgumentException("error " + fruit + " not null");
        }
        return map.getOrDefault(fruit, 0);
    }

    @Override
    public void add(String fruit, int quantity) {
        if (fruit == null || fruit.isBlank() || quantity < 0) {
            throw new IllegalArgumentException("error " + fruit + " not null");
        }
        int newValue = getFruit(fruit) + quantity;
        map.put(fruit, newValue);
    }

    @Override
    public void set(String fruit, int quantity) {
        if (fruit == null || fruit.isBlank() || quantity < 0) {
            throw new IllegalArgumentException("error " + fruit + " not null");
        }
        map.put(fruit, quantity);
    }

    @Override
    public void delete(String fruit, int quantity) {
        if (fruit == null || fruit.isBlank() || quantity < 0) {
            throw new IllegalArgumentException("error " + fruit + " not null");
        }
        if (quantity > getFruit(fruit)) {
            throw new RuntimeException("error the " + quantity + " is more than the balance.");
        }
        int value = getFruit(fruit) - quantity;
        map.put(fruit, value);
    }
}
