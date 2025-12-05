package BinaryTrees;

public class HeightOfTree { // "Hight" বানান ঠিক করে "Height" করা হয়েছে
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Tree-এর উচ্চতা (Height) বের করার ফাংশন
    public static int height(Node root) {
        if (root == null) {
            return 0; // যদি নোড না থাকে, উচ্চতা 0
        }

        // রিকারসিভলি বাম এবং ডান পাশের উচ্চতা বের করা
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // দুটির মধ্যে যেটি বড় তার সাথে ১ যোগ করে রিটার্ন করা
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int count(Node root){
        if(root==null){
            return 0;
        }
        int leftCount=count(root.left);
        int rightCount=count(root.right);
        return leftCount+rightCount+1;
    }

    public static int sum(Node root){
        if(root==null){
            return 0;
        }
        int leftSum=sum(root.left);
        int rightSum=sum(root.right);
        return leftSum+rightSum+root.data;
    }

    public static int diameter(Node root){
        if(root==null){
            return 0;
        }
        int leftDiam=diameter(root.left);
        int leftHt=height(root.left);
        int rightDiam=diameter(root.right);
        int rightHt=height(root.right);

        int selfDiam=leftHt+rightHt+1;
        return Math.max(selfDiam, Math.max(leftDiam,rightDiam));
    }

    static class Info{
        int dia;
        int ht;

        //constructer
        public Info(int dia, int ht){
            this.dia=dia;
            this.ht=ht;
        }
    }

    public static Info optimalDiam(Node root){
        if(root==null){
            return new Info(0,0);
        }
        Info leftInfo=optimalDiam(root.left);
        Info rightInfo=optimalDiam(root.right);

        int dia=Math.max(Math.max(leftInfo.dia, rightInfo.dia), leftInfo.ht+rightInfo.ht+1);
        int ht=Math.max(leftInfo.ht, rightInfo.ht)+1;

        return new Info(dia, ht);
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        // ভুল: Node.left = new Node(2);
        // সঠিক: root.left ব্যবহার করতে হবে
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);


        System.out.println("Height of tree is: " + height(root));
        System.out.println(count(root));
        System.out.println(sum(root));

        System.out.println(diameter(root));

        System.out.println(optimalDiam(root).dia);
    }
}