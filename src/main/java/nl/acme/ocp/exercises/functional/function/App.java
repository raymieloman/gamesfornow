package nl.acme.ocp.exercises.functional.function;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {

        Function<Double, String> squareFunc = a -> ""+(a*a);
//        squareFunc = Math::sqrt;
        Function<Integer, Integer> square = a -> a*a;
        UnaryOperator<Integer> square2 = a -> a*a;
        // mantra voor werken met Lambda Expressions!!! =>  () -> true;
    }
}
