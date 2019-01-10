package main;

import main.contract.CivilContract;
import main.contract.OrdinaryContract;
import main.contract.UnknownContractTypeException;
import main.input.InputParameters;

public class TaxCalculationExecutor {

    private InputParameters inputParameters;

    public TaxCalculationExecutor(InputParameters inputParameters) {
        this.inputParameters = inputParameters;
    }

    public void run() throws UnknownContractTypeException {
        if (inputParameters.getContractType() == 'O') {
            new OrdinaryContract(inputParameters.getIncome()).run();
        } else if (inputParameters.getContractType() == 'C') {
            new CivilContract(inputParameters.getIncome()).run();
        } else {
            throw new UnknownContractTypeException(inputParameters.getContractType());
        }
    }
}
