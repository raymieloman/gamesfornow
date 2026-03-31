package nl.acme.ocp.democode.functionalprogramming.methodreferences;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89);
        numbers.forEach(System.out::println);
        
    }
}
