package main.contract;

import java.util.HashMap;
import java.util.Map;

public enum ContractType {
    ORDINARY('O', OrdinaryContract.class),
    CIVIL('C', CivilContract.class);

    private final char typeId;
    private final Class contractCalculator;

    ContractType(char typeId, Class contractCalculator) {
        this.typeId = typeId;
        this.contractCalculator = contractCalculator;
    }

    private static final Map<Character, ContractType> map = new HashMap<>(values().length, 1);

    static {
        for (ContractType type : values()) {
            map.put(type.typeId, type);
        }
    }

    public Class getContractCalculator() {
        return contractCalculator;
    }

    public static ContractType of(char id) throws UnknownContractTypeException {
        ContractType result = map.get(id);
        if (result == null) {
            throw new UnknownContractTypeException(id);
        }
        return result;
    }
}
