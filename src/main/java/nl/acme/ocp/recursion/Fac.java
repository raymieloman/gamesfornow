package nl.acme.ocp.recursion;

public class Fac {
    public static int fac(int n) {
        // simplest case
        if (n == 0) {
            return 1;
        }
        else {
            return n * fac(n - 1);
        }
    }

    // Utility class so a private constructor
    private Fac() {
    }
}