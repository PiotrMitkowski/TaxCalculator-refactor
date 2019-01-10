package main;

import main.contract.Contract;
import main.contract.ContractType;
import main.contract.UnknownContractTypeException;
import main.input.InputParameters;

class TaxCalculationExecutor {

    private InputParameters inputParameters;

    TaxCalculationExecutor(InputParameters inputParameters) {
        this.inputParameters = inputParameters;
    }

    void run() throws UnknownContractTypeException, ReflectiveOperationException {
        char contractType = inputParameters.getContractType();
        ContractType type = ContractType.of(contractType);
        Class contractClass = type.getContractCalculator();
        Contract contract = (Contract)contractClass.getDeclaredConstructor(Double.class).newInstance(inputParameters.getIncome());
        contract.run();
    }
}
