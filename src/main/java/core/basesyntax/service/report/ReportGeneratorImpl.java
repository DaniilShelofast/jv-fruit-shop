package core.basesyntax.service.report;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private final Map<String, Integer> map;

    public ReportGeneratorImpl(Map<String, Integer> map) {
        if (map == null) {
            throw new RuntimeException("Error: ReportGenerator map must not be null");
        }
        this.map = new LinkedHashMap<>(map);
    }

    @Override
    public String getReport() {
        return map.entrySet().stream()
                .map(fr -> fr.getKey() + "," + fr.getValue())
                .collect(Collectors.joining("\n", "fruit,quantity\n", ""));
    }
}
