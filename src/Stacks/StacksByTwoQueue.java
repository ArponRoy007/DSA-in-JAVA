package Stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StacksByTwoQueue {
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty();
        }

        public static void push(int data) {
            // Push operation is now a single step
            // We always push to the main queue (q1)
            q2.add(data);
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            // Swap the queues so that q1 is the main queue again
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }
            return q1.remove(); // O(1) pop
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }
            return q1.peek(); // O(1) peek
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}