package nl.acme.ocp.democode.concurrency.threads;

public class App {
    static void main() {
        boolean isPlatform = false;
        if (isPlatform) {
            // implicit a non deamon thread, hence the main thread will wait for completion
            Thread.ofPlatform().start(() -> {
                System.out.println("Hello");
                System.out.println("World");
            });
        } else {
            //virtual thread, hence a daemon thread and the main thread will NOT wait for completion
            System.out.println("Creating a virtual thread");
            Thread.ofVirtual().start(() -> {
                System.out.println("Hello");
                System.out.println("World");
            });
        }

        System.out.println("End of program");
        if (isPlatform) {
            System.out.println("Watch that there should be Hello World");
        } else {
            System.out.println("Watch that there should NOT be Hello World (in most cases)");
        }
    }
}
