package main.input;

public class InputParameters {
    private Double income;
    private char contractType;

    public InputParameters(Double income, char contractType) {
        this.income = income;
        this.contractType = contractType;
    }

    public Double getIncome() {
        return income;
    }

    public char getContractType() {
        return contractType;
    }
}
