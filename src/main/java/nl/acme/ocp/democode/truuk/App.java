package nl.acme.ocp.democode.truuk;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class App {
    public static void main(String[] args) throws InterruptedException {

        final AtomicInteger counter = new AtomicInteger(0);
        Runnable r = () ->  {
            counter.incrementAndGet();
        };
        Thread t = new Thread(r);
        t.start();
        t.join();
        System.out.println(counter.get());
    }
}
