package nl.acme.ocp.democode.concurrency.synchronisation.finaldemo;

import java.util.concurrent.atomic.AtomicInteger;

public class Bakker {
    private final AtomicInteger voorraad;

    public Bakker(AtomicInteger voorraad) {
        this.voorraad = voorraad;
    }

    public void bak() throws InterruptedException {
        System.out.printf("Bakker ziet voorraad: %d%n", this.voorraad.incrementAndGet());
        Thread.sleep(300);
    }
}
