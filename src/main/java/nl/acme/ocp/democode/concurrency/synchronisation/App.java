package nl.acme.ocp.democode.concurrency.synchronisation;

public class App {
    public static void main(String[] args) {
        final Voorraad voorraad = new Voorraad();

        Thread bakker = new Thread(() -> {
            new Bakker(voorraad).bak();
        });
        bakker.start();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                new Klant(voorraad).koop();
            }).start();
        }
    }
}