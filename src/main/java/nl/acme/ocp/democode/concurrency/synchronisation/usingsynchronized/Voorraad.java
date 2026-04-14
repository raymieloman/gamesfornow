package nl.acme.ocp.democode.concurrency.synchronisation.usingsynchronized;

public class Voorraad {
    private int voorraad;

    public void bak() {
        synchronized (this) {
            voorraad++;
            System.out.println("Voorraad:" + voorraad);
            this.notify();
        }
    }

    // same as synchronized (this) // hence lock on the ENTIRE OBJECT!!!
    public synchronized void koop() throws InterruptedException {
        while (voorraad <= 0) {
            this.wait();
        }
        voorraad--;
        System.out.println("Voorraad:" + voorraad);
    }

    // deze method is NIET synchronized
    public int getVoorraad() {
        return voorraad;
    }
}
