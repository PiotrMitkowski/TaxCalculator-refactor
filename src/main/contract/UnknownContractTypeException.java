package main.contract;

public class UnknownContractTypeException extends Exception {


    public UnknownContractTypeException(char contractType) {
        super("Unknown contract type=" + contractType);
    }
}
