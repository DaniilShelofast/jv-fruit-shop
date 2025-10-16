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

    @Override
    public List<FruitTransaction> convertAll(List<String> line) {
        return line.stream()
                .skip(1)
                .map(this::lineSplit)
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
