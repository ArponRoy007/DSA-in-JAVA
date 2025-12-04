package LinkedList;

public class DoublyLL {
    public class Nodee{
        int data;
        Nodee next;
        Nodee prev;

        public Nodee(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Nodee head;
    public static Nodee tail;
    public static int size;

    //add
    public void addFirst(int data){
        Nodee newNode=new Nodee(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }

    //print
    public void print(){
        Nodee temp=head;
        while (temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    //remove
    public int removeFirst() {
        if (head == null) {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next; // Step 2: Move head to the next node
        head.prev = null; // Step 3: Disconnect the old head
        size--;
        return val;
    }

    public void reverse(){
        Nodee prev=null;
        Nodee curr=head;
        Nodee next;

        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public static void main(String[] args) {
        DoublyLL dll=new DoublyLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        //System.out.println(dll.size);
//        dll.removeFirst();
//        dll.print();
//        System.out.println(dll.size);

        dll.reverse();
        dll.print();
    }
}
