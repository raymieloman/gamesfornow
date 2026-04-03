package nl.acme.ocp.democode.recursion.reclist;

import java.util.Iterator;

import static nl.acme.utils.Assertion.*;

public class App {
    public static void main(String[] args) {
        RecList<Integer> r = new RecList<>();
        r.add(3);
        r.add(2);
        r.add(1);
        r.add(-2);

        assertTrue(r.contains(2));
        assertFalse(r.contains(334343));
        assertEquals(Integer.valueOf(3), r.get(0));
        assertEquals(Integer.valueOf(-2), r.get(3));
        assertTrue(r.delete(2));
        assertFalse(r.delete(89345783));
        assertFalse(r.contains(2));
        assertEquals(3, r.size());

        System.out.println(r);
        r.update(2, -33);

        assertTrue(r.contains(-33));
        assertEquals(3, r.size());

        r.sort();
        System.out.println(r);
        r.update(2, 55);
        System.out.println(r);

        assertTrue(r.get(33) == null);

        for (int o : r) {
            System.out.println("In loop: "+o);
        }
        for (Iterator<Integer> i = r.iterator(); i.hasNext(); ) {
            System.out.println("In for loop met iterator: "+i.next());
        }
    }
}
