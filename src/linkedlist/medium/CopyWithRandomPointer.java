package linkedlist.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyWithRandomPointer {
    public static void main(String[] args) {
        Node n = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);
        n.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        n.random = null;
        n1.random = n;
        n2.random = n4;
        n3.random = n2;
        n4.random = n;

        CopyWithRandomPointer cr = new CopyWithRandomPointer();
        Node node = cr.copyRandomList(n);
        System.out.println(node);
    }

    public Node copyRandomList(Node head) {
        Node current = head;
        Map<Node, Node> map = new HashMap<>();
        while (current != null) {
            Node n = new Node(current.val);
            map.put(current, n);
            current = current.next;
        }
        current = head;
        while (current != null) {
            Node n = map.get(current);
            n.next = map.get(current.next);
            n.random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
