package nl.acme.ocp.democode.concurrency.synchronisation;

public class Voorraad {
    private int voorraad;

    public void bak() {
        voorraad++;
        System.out.println("Voorraad:" + voorraad);
    }

    public void koop() {
        if (voorraad > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            voorraad--;
        }
        System.out.println("Voorraad:" + voorraad);
    }

    public int getVoorraad() {
        return voorraad;
    }
}
