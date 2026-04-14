package nl.acme.ocp.democode.designpatterns.singleton;

public class App {
    public static void main(String[] args) {
        Voorraad s = Voorraad.getInstance(42);
        System.out.println(s.getValue());
    }
}
