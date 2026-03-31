package nl.acme.ocp.democode.concurrency.synchronisation;

public class Klant {
    private Voorraad voorraad;

    public Klant(Voorraad voorraad) {
        this.voorraad = voorraad;
    }

    public void koop() {
        this.voorraad.koop();
    }
}
