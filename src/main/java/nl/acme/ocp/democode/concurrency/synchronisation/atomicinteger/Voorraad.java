package nl.acme.ocp.democode.concurrency.synchronisation.atomicinteger;

import java.util.concurrent.atomic.AtomicInteger;

public class Voorraad {
    private AtomicInteger voorraad = new AtomicInteger(0);

    public void bak() {
        voorraad.incrementAndGet();
        System.out.println("Voorraad:" + voorraad);
    }

    // same as synchronized (this) // hence lock on the ENTIRE OBJECT!!!
    public void koop() throws InterruptedException {
        voorraad.decrementAndGet();
        System.out.println("Voorraad:" + voorraad);
    }

    // deze method is NIET synchronized
    public int getVoorraad() {
        return voorraad.get();
    }
}
