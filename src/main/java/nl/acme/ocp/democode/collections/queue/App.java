package nl.acme.ocp.democode.collections.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) {
        {
            Queue<Integer> wachtrij = new LinkedList<>();
            wachtrij.add(3);
            wachtrij.offer(5);

            System.out.println(wachtrij.poll());
            System.out.println(wachtrij.poll());
            System.out.println(wachtrij.poll());
//            wachtrij.poll() // only poll nog pollFirst and not pollLast
        }

        {
            Deque<Integer> wachtrij = new LinkedList<>();
            wachtrij.addFirst(5);
            wachtrij.addLast(300);
            System.out.println(wachtrij.peekFirst());
            System.out.println(wachtrij.pollFirst());
            System.out.println(wachtrij.pollLast());
        }
    }
}
