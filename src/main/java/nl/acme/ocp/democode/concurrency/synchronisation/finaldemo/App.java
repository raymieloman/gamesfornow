package nl.acme.ocp.democode.concurrency.synchronisation.finaldemo;

import java.util.concurrent.atomic.AtomicInteger;

public class App {

    // Note, the Condition is only available when you have the lock!!!
    public static void main(String[] args) throws InterruptedException {
        final AtomicInteger voorraad = new AtomicInteger(0);

        for (int i = 0; i < 10; i++) {
            Thread bakker = new Thread(() -> {
                try {
                    new Bakker(voorraad).bak();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            bakker.start();
        }


        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    new Klant(voorraad).koop();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        // Check: weet je zeker dat hier 0 wordt geprint? :-) Niet dus! :-)
        System.out.println("Finale voorraad: "+voorraad);
        Thread.sleep(10000);
        System.out.println("Finale voorraad: "+voorraad);
    }
}