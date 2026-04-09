package nl.acme.ocp.democode.concurrency.executorservices;

import java.util.concurrent.*;

import static nl.acme.utils.Assertion.assertFalse;
import static nl.acme.utils.Assertion.assertTrue;

public class App {
    public static void main(String[] args) throws ExecutionException, TimeoutException, InterruptedException {
        Callable<Integer> mycallable = () -> {
            Thread.sleep(3000);
            return 42;
        };
        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            Future<Integer> futureResult = service.submit(mycallable);

            // Hij wordt hier geblocked als het resultaat er nog niet is!
            assertFalse(futureResult.isCancelled());
            assertFalse(futureResult.isDone());
            boolean cancelled = futureResult.cancel(true);
            if (!cancelled) {
                System.out.println(futureResult.get());
            }

            assertTrue(futureResult.isDone());

            System.out.println(service.submit(() -> 133).get(3, TimeUnit.NANOSECONDS));
            service.shutdown();
        }
//        service.close(); // hoeft niet meer als ik hem in een try with resources block heb gehangen
    }

}
