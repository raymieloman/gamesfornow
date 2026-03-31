package nl.acme.ocp.democode.functionalprogramming;

import java.util.List;

@FunctionalInterface
interface CanHop {
    boolean test();
}

@FunctionalInterface
interface GiveAge {
    int verjaar(int age);
}

// extra werk

class Animal implements CanHop {

    @Override
    public boolean test() {
        return true;
    }

}


public class App {

    public static void main(String[] args) {
        // normaal gedrag
        Animal a = new Animal();
        CanHop h1 = new Animal();

        GiveAge ga = x -> x+1;
        GiveAge ga2 = (x) -> x+1; // haakjes zijn hier dus optioneel
        GiveAge ga3 = (int x) -> {
            return x+33;
        };

        // functional
        CanHop h = () -> true;
        CanHop h3 = () -> {
            System.out.println("Ik ben nu in h3");
            return true;
        };
        CanHop h4 = () -> 5>2 ? true: false;

        CanHop h2 = () -> {
            if(Math.random() >= 0.5d) {
                return true;
            } else {
                return false;
            }
        };

        canHopper(List.of(a,h1, h, () -> false, () -> {
            return Math.random() > 0.5d ? true : false;
        }));
    }

    public static void canHopper(List<CanHop> hoppers) {
        for (CanHop h : hoppers) {
            System.out.println(h.test());
        }
    }
}

