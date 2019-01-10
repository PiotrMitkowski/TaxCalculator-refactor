package main.presenting;

public class Logger implements Presenter {

    public void present(String... args) {
        for (String arg : args) {
            System.out.print(arg);
        }
        System.out.println();
    }

}
