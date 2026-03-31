package nl.acme.ocp.democode.functionalprogramming.builtinfunctionalinterfaces;

import java.util.function.Supplier;

class MySuppier implements Supplier<String> {

    @Override
    public String get() {
        return "It rocks in the MySupplier implementatie!";
    }
}

public class App {

    public static void main(String[] args) {
        foo(String::new);

        foo(() -> "It rocks");
        foo(() -> "It sucks");
        foo(new MySuppier());


    }

    public static void foo(Supplier<String> createLabel) {
        System.out.println(createLabel.get());
    }
}
