package main;

import main.contract.CivilContract;
import main.contract.OrdinaryContract;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TaxCalculator {

    private static Logger logger = new Logger();

    public static double income = 0;
    public static char contractType = ' ';

    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.print("Provide income: ");
            income = Double.parseDouble(br.readLine());

            System.out.print("Contract type: (O)rdinary, (C)ivil: ");
            contractType = br.readLine().charAt(0);

        } catch (Exception ex) {
            logger.present("Incorrect value");
            ex.printStackTrace();
            return;
        }
        if (contractType == 'O') {
            new OrdinaryContract(income).run();
        } else if (contractType == 'C') {
            new CivilContract(income).run();
        } else {
            logger.present("Unknown contract!");
        }
    }
}
