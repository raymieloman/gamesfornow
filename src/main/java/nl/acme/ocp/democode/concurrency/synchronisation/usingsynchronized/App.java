package nl.acme.ocp.democode.concurrency.synchronisation.usingsynchronized;

public class App {
    public static void main(String[] args) {
        final Voorraad voorraad = new Voorraad();

        for (int i = 0; i < 10; i++) {
            Thread bakker = new Thread(() -> {
                new Bakker(voorraad).bak();
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

        // Check: weet je zeker dat hier 0 wordt geprint? :-)
        System.out.println("Finale voorraad: "+voorraad.getVoorraad());
    }
}