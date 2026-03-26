package nl.acme.ocp.democode.collections;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // List.of levert een Immutable list
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
//        numbers.add(13); // fails at runtime

        // idem dito
        numbers = Arrays.asList(1, 2, 3, 4, 5);
//        numbers.add(13);// meltdown at runtime


        numbers = new ArrayList<>();
        numbers.addAll(List.of(1, 2, 3, 4, 5));
        numbers.add(13);

    }
}
