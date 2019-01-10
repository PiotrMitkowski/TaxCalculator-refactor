package main.input;

import java.io.IOException;

public interface InputProvider {

    InputParameters provide() throws IOException;
}
