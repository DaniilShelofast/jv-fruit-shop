package core.basesyntax.db;

import java.util.Map;

public class StorageImpl implements Storage {
    private final Map<String, Integer> map;

    public StorageImpl(Map<String, Integer> map) {
        if (map == null) {
            throw new RuntimeException("Map must not be null");
        }
        this.map = map;
    }

    @Override
    public int getFruit(String fruit) {
        if (fruit == null || fruit.isBlank()) {
            throw new IllegalArgumentException(fruit + " must be non-null and non-empty");
        }
        return map.getOrDefault(fruit, 0);
    }

    @Override
    public void add(String fruit, int quantity) {
        if (fruit == null || fruit.isBlank()) {
            throw new IllegalArgumentException(fruit + " must be non-null and non-empty");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException(quantity + " must be non-negative");
        }
        int newValue = getFruit(fruit) + quantity;
        map.put(fruit, newValue);
    }

    @Override
    public void set(String fruit, int quantity) {
        if (fruit == null || fruit.isBlank()) {
            throw new IllegalArgumentException(fruit + " must be non-null and non-empty");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException(quantity + " must be non-negative");
        }
        map.put(fruit, quantity);
    }

    @Override
    public void delete(String fruit, int quantity) {
        if (fruit == null || fruit.isBlank()) {
            throw new IllegalArgumentException(fruit + " must be non-null and non-empty");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException(quantity + " must be non-negative");
        }
        int findFruit = getFruit(fruit);
        if (quantity > findFruit) {
            throw new RuntimeException("Can't delete " + quantity + " of "
                    + fruit + " only " + getFruit(fruit) + " in stock");
        }
        int value = findFruit - quantity;
        map.put(fruit, value);
    }
}
