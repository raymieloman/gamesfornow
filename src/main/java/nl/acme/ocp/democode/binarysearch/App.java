package nl.acme.ocp.democode.binarysearch;

import java.util.*;

import static nl.acme.utils.Assertion.assertEquals;
import static nl.acme.utils.Assertion.assertTrue;

public class App {


    class Person {

    }
    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<>(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 433, 512, 82193, 21, 34, 55, 89)); // List.of kan ook hier ...
        Collections.sort(numbers);

        assertEquals(4, Collections.binarySearch(numbers, 3));
        assertEquals(-7, Collections.binarySearch(numbers, 6));

        numbers.add(144); // dat lukt
        assertTrue(numbers.contains(144));
    }
}
