package nl.acme.ocp.democode.concurrency.synchronisation;

public class Bakker {
    private Voorraad voorraad;
    public Bakker(Voorraad voorraad) {
        this.voorraad = voorraad;
    }

    public void bak() {
        this.voorraad.bak();
    }
}
