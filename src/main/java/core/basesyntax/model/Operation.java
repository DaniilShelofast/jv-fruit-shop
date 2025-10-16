package core.basesyntax.model;

import java.util.Arrays;

public enum Operation {

    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String type;

    Operation(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Operation getOperationType(String type) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getType().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("error : element not found."));
    }
}

