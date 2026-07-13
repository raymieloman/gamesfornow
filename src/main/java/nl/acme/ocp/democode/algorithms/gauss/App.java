package nl.acme.ocp.democode.algorithms.gauss;

import nl.acme.utils.Assertion;

public class App {

    public static void main(String[] args) {
        System.out.println(gauss(3));
        Assertion.assertEquals(6, gauss(3)); // 1+2+3
    }

    // adds 1..n
    public static int gauss(int n) {
        return n*(n+1)/2;
    }
}
