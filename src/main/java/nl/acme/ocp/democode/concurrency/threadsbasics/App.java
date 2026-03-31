package nl.acme.ocp.democode.concurrency.threadsbasics;

class MyThread extends Thread {
    private final int id;

    MyThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Running thread with id: " + id + " and counter: " + i);
        }
    }
}

public class App {

    public static void main(String[] args) {
        for (int i = 1; i <= 15; i++) {
            Thread t = new MyThread(i);
            t.start(); // now this thread is Runnable (in de scheduler)
        }

        // ocp instinkertje
//        t.run(); // dit is geen concurrency
        System.out.println("einde programma");
    }
}
