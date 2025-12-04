package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//queues reversal
public class QueuesSix {
    public static int reversal(Queue<Integer> q){
        Stack<Integer> s=new Stack<>();

        while (!q.isEmpty()){
            s.add(q.remove());
        }
        while (!s.isEmpty()){
            q.add(s.pop());
        }
        return q.peek();
    }

    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        reversal(q);
        while (!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
        System.out.println();
    }
}
