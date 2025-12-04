package LinkedList;

import javax.print.attribute.standard.SheetCollate;
import java.time.chrono.MinguoDate;
import java.util.LinkedList;

public class LinkedListOne {
    public static class Node{
        int data;
        Node next;

        //constructor:A constructor in Java is a
        // special method used to initialize
        // objects when they are created
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //methods:
    //add first //tc:O(1)
    public void addFirst(int data){
        //step1:create new node
        Node newNode=new Node(data);
        size++;
        //when ll is empty
        if (head==null){
            head=tail=newNode;
            return;
        }

        //step2: linked the newNode with next node
        newNode.next=head; //linking
        //step3: replace head to newNode
        head=newNode;
    }

    //add last //tc:O(1)
    public void addLast(int data){
        //step1:create new node
        Node newNode=new Node(data);
        size++;
        //when ll is empty
        if (head==null){
            head=tail=newNode;
            return;
        }

        //step2: linked the tail with newNode
        tail.next=newNode; //linking
        //step3: replace tail to newNode
        tail=newNode;
    }

    //print the ll
    public void print(){
        if (head==null){
            System.out.println("LL is empty...");
            return;
        }
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    //add in middle //tc:O(n)
    public void add(int idx,int data){
        if (idx==0){
            addFirst(data);
            return;
        }
        //step1:create new node
        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;

        while (i<idx-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }

    //remove from first
    public int removeFirst(){
        if (size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    //remove from last
    public int removeLast(){
        if (size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        //prev:i=size-2
        Node prev=head;
        for (int i=0; i<size-2; i++){
            prev=prev.next;
        }
        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }

    //Search(Iterative) O(n)
    public int itrSearch(int key){
        Node temp=head;
        int i=0;

        while (temp!=null){
            if (temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }

    //Search(Recursive)
    public int helper(Node head,int key){
        if (head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next, key);
        if (idx==-1){
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key){
        return helper(head, key);
    }

    //Reverse (vvi) O(n)
    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;

        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    //find and remove nth node from end
    public void deleteNthFormEnd(int n){
        //calculate size
        int sz=0;
        Node temp=head;
        while (temp!=null){
            temp=temp.next;
            sz++;
        }

        if (n==sz){
            head=head.next; //remove first
            return;
        }

        //sz-n
        int i=1;
        int iToFind=sz-n;
        Node preve=head;
        while (i<iToFind){
            preve=preve.next;
            i++;
        }
        preve.next=preve.next.next;
        return;
    }

    //check palindrome
    public Node findMid(Node head){
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2
        }
        return slow; //slow is my midNode
    }

    public boolean checkPalindrome(){
        if (head==null||head.next==null){
            return true;
        }
        //step-1:find mid
        Node midNode=findMid(head);

        //step-2:reverse 2nd half
        Node prev=null;
        Node curr=midNode;
        Node next;

        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node right=prev;//right half head
        Node left=head;

        //step-3:check left half & right half
        while (right!=null){
            if (left.data!=right.data){
                return false;
            }
            left=left.next;
            right = right.next;
        }
        return true;
    }


    //class two
    //Floy's CFA
    public boolean isCycle(){
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2
            if (slow==fast){
                return true;//cycle exists
            }
        }
        return false;
    }

    //remove cycle
    public static void removeCycle(){
        //detect cycle
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while (fast!=null && fast.next!=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2
            if (slow==fast){
                cycle=true;
                break;
            }
        }
        if (cycle==false){
            return;
        }

        //find meeting point
        slow=head;
        Node prev=null;//last node
        while (slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }

        //remove cycle->last.next=null
        prev.next=null;
    }




    private Node merge(Node head1, Node head2){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;

        while (head1!=null&&head2!=null){
            if (head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            } else {
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while (head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while (head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }

    private Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;//+1
            fast = fast.next.next;
        }
        return slow;
    }

    public Node mergeSort(Node head){
        if (head==null || head.next==null){
            return head;
        }
        //find mid
        Node mid=getMid(head);

        //left & right MS
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);
    }


    //zig-zag
    public void zigZag(){
        //find mid
        Node slow=head;
        Node fast=head.next;

        while (fast!=null && fast.next!=null) {
            slow = slow.next;//+1
            fast = fast.next.next;
        }
        Node mid=slow;

        //reverse second half
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;

        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node left=head;
        Node right=prev;
        Node nextL,nextR;

        //alt merge-zig-zag merge
        while (left!=null && right!=null){
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            left=nextL;
            right=nextR;
        }
    }


    public static void main(String[] args) {
        LinkedListOne ll=new LinkedListOne();
//        ll.print();
//        ll.addFirst(2);
//        ll.print();
//        ll.addFirst(1);
//        ll.print();
//        ll.addLast(3);
//        ll.print();
//        ll.addLast(4);
//        ll.print();

//        ll.add(2,9);
//        ll.print();
//        System.out.println(size);

//        ll.removeFirst();
//        ll.print();
//        ll.removeLast();
//        ll.print();

//        System.out.println(ll.itrSearch(3));
//        System.out.println(ll.recSearch(2));
//
//        ll.reverse();
//        ll.print();
//
//        ll.deleteNthFormEnd(1);
//        ll.print();

//        ll.addLast(1);
//        ll.addLast(2);
//        ll.addLast(2);
//        ll.addLast(1);
//        ll.print();
//        System.out.println(ll.checkPalindrome());


        //class two
//        head=new Node(1);
//        Node temp=new Node(2);
//        head.next=temp;
//        head.next.next=new Node(3);
//        head.next.next.next=temp;
        //1->2->3->1
//        System.out.println(ll.isCycle());
//        removeCycle();
//        System.out.println(ll.isCycle());


        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        //ll.head=ll.mergeSort(ll.head);
        ll.zigZag();
        ll.print();
    }
}
