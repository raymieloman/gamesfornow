package nl.acme.ocp.democode.algorithms.binet;

import nl.acme.utils.Assertion;

public class App {

    public static void main(String[] args) {
        Assertion.assertEquals(0, binet(0));
        Assertion.assertEquals(1, binet(1));
        Assertion.assertEquals(1, binet(2));
        Assertion.assertEquals(2, binet(3));
        Assertion.assertEquals(5, binet(5));
        Assertion.assertEquals(55, binet(10));
    }

    // 0 1 1 2 3 5 8 13 21 34 55 89 (index based)
    public static long binet(int n) {
        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5) / 2;       // golden ratio ≈ 1.618...
        double psi = (1 - sqrt5) / 2;       // conjugate ≈ -0.618...

        double result = (Math.pow(phi, n) - Math.pow(psi, n)) / sqrt5;
        return Math.round(result);
    }
}
