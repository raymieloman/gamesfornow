package nl.acme.ocp.recursion;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println(Fac.fac(3));
        System.out.println(Fac.fac(4));
        System.out.println(Fac.fac(5));

        List<String> names = new ArrayList<>(); // diamond operator
        names.add("asdfadf");
    }
}
