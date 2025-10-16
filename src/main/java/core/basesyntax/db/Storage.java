package core.basesyntax.db;

public interface Storage {
    int getFruit(String fruit);

    void add(String fruit, int quantity);

    void set(String fruit, int quantity);

    void delete(String fruit, int quantity);
}
