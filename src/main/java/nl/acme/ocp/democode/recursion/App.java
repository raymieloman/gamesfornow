package nl.acme.ocp.democode.recursion;

import static nl.acme.ocp.democode.recursion.MathStuff.fac;
import static nl.acme.utils.Assertion.assertEquals;

public class App {
    public static void main(String[] args) {
        System.out.println(fac(3));
        System.out.println(fac(4));
        System.out.println(fac(5));

        assertEquals(720, fac(6));
    }
}
