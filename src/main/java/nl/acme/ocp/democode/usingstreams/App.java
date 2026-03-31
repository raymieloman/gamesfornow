package nl.acme.ocp.democode.usingstreams;

import java.util.List;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89);

        Stream<Integer> someStream = numbers.stream().map(n -> n * n).peek(n -> {
                    System.out.println("Peeking: " + n);
                }).
                filter(n -> n < 60);//.forEach(System.out::println);
        Stream<Integer> alias = someStream;
        someStream.forEach(System.out::println);

//        System.out.println(alias.count());
//        System.out.println(someStream.count());
    }
}
