package nl.acme.ocp.democode.algorithms.ggd;

import static nl.acme.utils.Assertion.assertEquals;

public class App {
    public static void main(String[] args) {

        // ggd
        assertEquals(3, ggd(9,6));
        assertEquals(9, ggd(18,27));
        assertEquals(4, ggd(8,12));

        // kgv
        assertEquals(300, kgv(30,100));
        assertEquals(45, kgv(15,45));
        assertEquals(150, kgv(15,50));

    }

    public static int ggd(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return ggd(n, m % n);
        }
    }

    public static int kgv(int m, int n) {
        return m*n/ggd(m,n);
    }
}
