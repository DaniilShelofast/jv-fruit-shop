package core.basesyntax.service.converter;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    private static final String SPLIT = ",";
    private static final int INDEX_TYPE = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_NUMBER = 2;
    private static final int ARRAYS_LENGTH = 3;

    @Override
    public List<FruitTransaction> convertAll(List<String> line) {
        if (line == null) {
            throw new RuntimeException("Can`t list must not be null");
        }
        if (line.isEmpty()) {
            throw new RuntimeException("Can`t list must not be empty");
        }
        return line.stream()
                .skip(1)
                .map(this::lineSplit)
                .filter(strings -> {
                    if (strings.length != ARRAYS_LENGTH) {
                        throw new RuntimeException(
                                "Incorrect CSV format: 3 columns expected "
                                        +
                                        "(type, fruit, quantity), but received "
                                        +
                                        strings.length + ". Error string : "
                                        +
                                        String.join(",", strings)
                        );
                    }
                    return true;
                })
                .map(f -> new FruitTransaction(
                        Operation.getOperationType(f[INDEX_TYPE].toLowerCase()),
                        validateEmptyAndNull(f[INDEX_FRUIT]), validateNumber(f[2])))
                .collect(Collectors.toList());
    }

    private String[] lineSplit(String line) {
        return Arrays.stream(line.split(SPLIT))
                .map(String::trim)
                .toArray(String[]::new);
    }

    private String validateEmptyAndNull(String fruit) {
        if (fruit == null) {
            throw new RuntimeException("fruit cannot be null");
        }
        if (fruit.isBlank()) {
            throw new RuntimeException("fruit cannot be empty");
        }
        return fruit;
    }

    private int validateNumber(String number) {
        int value;
        try {
            value = Integer.parseInt(number);
        } catch (RuntimeException e) {
            throw new RuntimeException("Incorrect number format: " + number, e);
        }
        if (value < 0) {
            throw new RuntimeException("Error number should not be negative");
        }
        return value;
    }
}
