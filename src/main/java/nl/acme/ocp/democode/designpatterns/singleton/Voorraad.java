package nl.acme.ocp.democode.designpatterns.singleton;

public class Voorraad {
    private static Voorraad instance;
    private int value;

    public synchronized static Voorraad getInstance(int value) {
        if (instance == null) {
            instance = new Voorraad(value);
        }
        return instance;
    }


    private Voorraad(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
