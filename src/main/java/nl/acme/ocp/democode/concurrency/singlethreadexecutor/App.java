package nl.acme.ocp.democode.concurrency.singlethreadexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    static void main() {
        Runnable printInventory = () -> System.out.println("Printing Zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing record: " + i);
//                Thread.sleep(3);
            }
        };
        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            System.out.println("Begin");
            executorService.execute(printInventory);
            executorService.execute(printRecords);
            executorService.execute(printInventory);
            System.out.println("End");
        }
    }
}
