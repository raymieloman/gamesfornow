package nl.acme.ocp.democode.concurrency.synchronisation.locking;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Voorraad {
    private int voorraad;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void bak() {
        try {
            lock.lock();
            voorraad++;
        } finally {
            condition.signal(); // valid location
            lock.unlock();
            //. invalid location !!! condition.signal();
        }
        // invalid location!!! Runtime error! : => condition.signal();

        System.out.println("Voorraad:" + voorraad);
    }

    // same as synchronized (this) // hence lock on the ENTIRE OBJECT!!!
    public void koop() throws InterruptedException {
        try {
            lock.lock();
            while (voorraad <= 0) {
                this.condition.await();
            }
            voorraad--;
        } finally {
            lock.unlock();
        }
        System.out.println("Voorraad:" + voorraad);
    }

    // deze method is NIET synchronized
    public int getVoorraad() {
        return voorraad;
    }
}
