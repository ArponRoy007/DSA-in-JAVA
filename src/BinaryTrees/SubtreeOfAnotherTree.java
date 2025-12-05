package BinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfAnotherTree {

    // 1. Node ক্লাস ঠিক করা হয়েছে
    static class Node {
        int data;
        Node left;  // আগে ভুল ছিল (HeightOfTree.Node ছিল)
        Node right; // আগে ভুল ছিল

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /*   //SUBTREE OF A ANOTHER TREE
    public static boolean isIdentical(Node node, Node subRoot){
        if (node==null && subRoot==null){
            return true;
        } else if (node==null || subRoot==null) {
            return false;
        }

        if (!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot){
        if (root==null){
            return false;
        }
        if (root.data== subRoot.data){
            if (isIdentical(root, subRoot)){
                return true;
            }
        }
        boolean leftAns= isSubtree(root.left, subRoot);
        boolean rightAns=isSubtree(root.right, subRoot);
        return leftAns||rightAns;
    } */


    //TOP VIEW OF A TREE:
    static class Info{
        Node node;
        int hd;

        public Info(Node node, int hd){
            this.node=node;
            this.hd=hd;
        }
    }

    public static void topView(Node root){
        //level order
        Queue<Info> q=new LinkedList<>();
        HashMap<Integer, Node> map=new HashMap<>();

        int min=0, max=0;
        q.add(new Info(root, 0));
        q.add(null);

        while (!q.isEmpty()){
            Info curr=q.remove();
            if (curr==null){
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                //important line
                if (!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left!=null){
                    q.add(new Info(curr.node.left, curr.hd-1));
                    min=Math.min(min, curr.hd-1);
                }

                if (curr.node.right!=null){
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max=Math.max(max, curr.hd+1);
                }
            }
        }

        for (int i=min; i<=max; i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // Main Tree (Root) তৈরি
        Node root = new Node(1);

        // 2. সব জায়গায় 'new Node' ব্যবহার করা হয়েছে
        root.left = new Node(2);       // HeightOfTree.Node বাদ দেওয়া হয়েছে
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Subtree (SubRoot) তৈরি
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5); // এখানেও লোকাল Node ব্যবহার করা হয়েছে

        System.out.println("Trees created successfully without errors.");
        //System.out.println(isSubtree(root,subRoot));

        topView(root);
    }
}