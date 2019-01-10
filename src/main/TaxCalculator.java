package main;

import main.contract.UnknownContractTypeException;
import main.input.ConsoleInputProvider;
import main.input.InputParameters;

import java.io.IOException;

public class TaxCalculator {

    public static void main(String[] args) {
        try {
            InputParameters parameters = new ConsoleInputProvider().provide();
            new TaxCalculationExecutor(parameters).run();
        } catch (IOException | UnknownContractTypeException exception) {
            exception.printStackTrace();
        }
    }
}
