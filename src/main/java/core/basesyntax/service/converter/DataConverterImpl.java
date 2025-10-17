package core.basesyntax.service.converter;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    private static final String SPLIT = ",";
    private static final String HEAD_FILE = "type,fruit,quantity";
    private static final int INDEX_TYPE = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_NUMBER = 2;
    private static final int COUNT_INDEX = 3;

    @Override
    public List<FruitTransaction> convertAll(List<String> line) {
        if (line == null || line.isEmpty()) {
            throw new RuntimeException("Input lines list must not be null");
        }
        if (!line.get(0).equals(HEAD_FILE)) {
            throw new IllegalArgumentException("incorrect header content");
        }
        return line.stream()
                .skip(1)
                .map(this::lineSplit)
                .filter(strings -> {
                    if (strings.length != COUNT_INDEX) {
                        throw new RuntimeException("Each row of data must have exactly "
                                +
                                "3 columns: type, fruit, quantity.");
                    }
                    return true;
                })
                .map(f -> new FruitTransaction(
                        Operation.getOperationType(f[INDEX_TYPE].toLowerCase()),
                        f[INDEX_FRUIT], Integer.parseInt(f[INDEX_NUMBER])))
                .collect(Collectors.toList());
    }

    private String[] lineSplit(String line) {
        return Arrays.stream(line.split(SPLIT))
                .filter(s -> !s.isBlank())
                .map(String::trim)
                .toArray(String[]::new);
    }
}
