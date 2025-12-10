package BST;

public class AVLTree {

    // ১. নোড ক্লাস (Node Class)
    static class Node {
        int data, height;
        Node left, right;

        Node(int d) {
            data = d;
            height = 1; // নতুন নোড সবসময় height 1 নিয়ে শুরু হয়
        }
    }

    Node root;

    // ২. হাইট বের করার হেল্পার ফাংশন (নিরাপদ উপায়)
    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // ৩. ব্যালেন্স ফ্যাক্টর বের করা (Left Height - Right Height)
    int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    // ৪. Right Rotate (বাম দিকে ভারী হলে ডান দিকে ঘোরাতে হয়)
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Rotation
        x.right = y;
        y.left = T2;

        // Height আপডেট (আগে y, তারপর x)
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x; // x এখন নতুন রুট
    }

    // ৫. Left Rotate (ডান দিকে ভারী হলে বাম দিকে ঘোরাতে হয়)
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Rotation
        y.left = x;
        x.right = T2;

        // Height আপডেট
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y; // y এখন নতুন রুট
    }

    // ৬. ইনসার্ট ফাংশন (আসল লজিক)
    Node insert(Node node, int data) {
        // ধাপ ১: সাধারণ BST ইনসার্ট
        if (node == null)
            return (new Node(data));

        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);
        else
            return node; // ডুপ্লিকেট এলাউড না

        // ধাপ ২: হাইট আপডেট করা
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // ধাপ ৩: ব্যালেন্স চেক করা
        int balance = getBalance(node);

        // ধাপ ৪: যদি ব্যালেন্স নষ্ট হয়, তবে ৪টি কেস হ্যান্ডেল করা

        // Case 1: Left Left (বামের বামে বেশি) -> Right Rotate
        if (balance > 1 && data < node.left.data)
            return rightRotate(node);

        // Case 2: Right Right (ডানের ডানে বেশি) -> Left Rotate
        if (balance < -1 && data > node.right.data)
            return leftRotate(node);

        // Case 3: Left Right (বামের ডানে বেশি) -> Left Rotate then Right Rotate
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Case 4: Right Left (ডানের বামে বেশি) -> Right Rotate then Left Rotate
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node; // যদি সব ঠিক থাকে, নোডটি রিটার্ন করো
    }

    // ট্রি চেক করার জন্য Preorder Traversal
    void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* সাধারণ BST হলে এটি সোজা লাইন হতো (10->20->30),
           কিন্তু AVL নিজেকে ব্যালেন্স করে নেবে */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \    \
        10  25   50
        */

        System.out.println("Preorder traversal of constructed AVL tree is:");
        tree.preorder(tree.root);
    }
}
