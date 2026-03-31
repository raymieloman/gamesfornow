package nl.acme.ocp.democode.recursion.hanoi;

public class Hanoi {

    public static void hanoi(int aantal) {
        hanoi(aantal, 'A', 'B', 'C');
    }

    private static void hanoi(int aantal, char from, char via, char to) {
        if (aantal == 0) {
            return;
        }
        hanoi(aantal - 1, from, to, via);
        System.out.println("Move from " + from + " to " + to);
        hanoi(aantal-1, via, from, to);
    }
}
