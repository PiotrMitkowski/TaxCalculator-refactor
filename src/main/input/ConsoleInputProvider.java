package main.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputProvider implements InputProvider {

    @Override
    public InputParameters provide() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.print("Provide income: ");
        double income = Double.parseDouble(br.readLine());

        System.out.print("Contract type: (O)rdinary, (C)ivil: ");
         char contractType = br.readLine().charAt(0);
        return new InputParameters(income, contractType);
    }
}
