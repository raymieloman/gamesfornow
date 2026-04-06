package nl.acme.ocp.democode.concurrency.submitting;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

public class App {

    static void main() {
        demoRunnable();
        demoCallable();
        demoRunnableWithAResult(); // not in the book
    }

    static void demoRunnableWithAResult() { // wat moet je hier nu mee? :-)
        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            Future<Integer> result = service.submit(() -> {
                System.out.println("It rocks");

            }, 42);
            assertEquals(42, result.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void demoCallable() {
        Callable<Double> randomInt = Math::random;
        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            Future<Double> result = service.submit(randomInt);
            assertNotNull(result.get());
            System.out.println(result.get());
            assertTrue(result.get() > 0 && result.get() <= 1);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void demoRunnable() {
        // runnable
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(STR."Printing record: \{i}");
            }
        };
        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            Future<?> result = service.submit(printRecords);
            assertNull(result.get()); // always null for a runnable
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
