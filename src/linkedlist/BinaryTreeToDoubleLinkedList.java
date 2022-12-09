package linkedlist;

public class BinaryTreeToDoubleLinkedList {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        // convert to DLL
    }

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    static class BinaryTree {
        // Initialize previously visited node as NULL. This is
        // static so that the same value is accessible in all
        // recursive calls
        static Node prev = null;
        Node root;
        // head --> Pointer to head node of created doubly
        // linked list
        Node head;

        // A simple utility recursive function to convert a
        // given Binary tree to Doubly Linked List root --> Root
        // of Binary Tree}
    }
}
