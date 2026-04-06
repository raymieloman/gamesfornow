package nl.acme.ocp.democode.concurrency.scheduling;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    static void main() {
        System.out.println(LocalDateTime.now());
        try(ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor()) { // !!!
            service.schedule(() -> {
                System.out.println("Hello later world");
                System.out.println(LocalDateTime.now());
            }, 3, TimeUnit.SECONDS);
        }
    }
}
