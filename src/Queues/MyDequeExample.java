package Queues;

import java.util.Deque; // Import the Deque interface
import java.util.LinkedList; // Import a class that implements the Deque interface

public class MyDequeExample { // Renamed the class to avoid confusion
    public static void main(String[] args) {
        // Correct way to use a Deque
        Deque<Integer> deque = new LinkedList<>(); // Instantiate a LinkedList to use as a Deque

        deque.addFirst(2);
        deque.addFirst(1);
        deque.addLast(3);
        System.out.println(deque);
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque);
    }
}