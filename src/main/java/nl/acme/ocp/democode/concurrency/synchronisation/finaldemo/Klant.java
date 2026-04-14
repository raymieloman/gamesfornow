package nl.acme.ocp.democode.concurrency.synchronisation.finaldemo;

import java.util.concurrent.atomic.AtomicInteger;

public class Klant {
    private final AtomicInteger voorraad;

    public Klant(AtomicInteger voorraad) {
        this.voorraad = voorraad;
    }

    public void koop() throws InterruptedException {
        System.out.printf("Klant ziet voorraad: %d%n", this.voorraad.decrementAndGet());
        Thread.sleep(300);
    }
}
