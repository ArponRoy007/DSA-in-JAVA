package Queues;

public class QueuesByArray {
    static class QueueA {
        static int arr[];
        static int size;
        static int rear;
        static int front; // Missing variable, added to track the front of the queue

        QueueA(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1; // Initialized to -1
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1; // Corrected condition
        }

        // Added this method to check for a full queue in a circular array
        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // add
        public static void add(int data) {
            if (isFull()) {
                System.out.println("queue is full");
                return;
            }
            if (front == -1) { // Sets front for the very first element
                front = 0;
            }
            rear = (rear + 1) % size; // Uses modulo for circular behavior
            arr[rear] = data;
        }

        // remove
        public static int remove() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            int result = arr[front];
            if (rear == front) { // Condition for removing the last element
                rear = front = -1;
            } else {
                front = (front + 1) % size; // O(1) removal
            }
            return result;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            return arr[front]; // Correctly returns the front element
        }

    }

    public static void main(String[] args) {
        QueueA q = new QueueA(5); // Corrected constructor call with a size
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove(); // Added remove() call to prevent infinite loop
        }
    }
}