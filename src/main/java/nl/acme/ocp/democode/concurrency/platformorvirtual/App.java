package nl.acme.ocp.democode.concurrency.platformorvirtual;

class RuudRunner implements Runnable {

    @Override
    public void run() {
        System.out.println("Running Roadrunner Ruud");
    }
}

public class App {
    public static void main(String[] args) {

        // Sinds Java21 kunnen we kiezen tussen een standaard platform thread
        // of een nieuwe virtual thread.
        Thread.Builder.OfVirtual threadBuilder = Thread.ofVirtual();

        threadBuilder.start(() -> {
            System.out.println("Welkom in de Runnable instance in deze thread");
        });

        threadBuilder.start(new RuudRunner());
    }
}
