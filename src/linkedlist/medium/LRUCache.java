package linkedlist.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer, Node> cacheMap;
    Node head, tail;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cacheMap = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.previous = head;


    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));


       /* //[[1],[2,1],[2],[3,2],[2],[3]]
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        System.out.println(cache.get(2));
        cache.put(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        */

    }

    public void removeNode(Node n) {
        n.previous.next = n.next;
        n.next.previous = n.previous;

    }

    public void addToHead(Node n) {
        n.next = head.next;
        n.next.previous = n;
        n.previous = head;
        head.next = n;
    }

    public int get(int key) {

        if (cacheMap.containsKey(key)) {
            Node n = cacheMap.get(key);
            int res = n.value;
            removeNode(n);
            addToHead(n);
            return res;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node n;

        if (cacheMap.containsKey(key)) {
            n = cacheMap.get(key);
            n.value = value;
            removeNode(n);
            addToHead(n);
        } else {
            n = new Node(key, value);
            cacheMap.put(key, n);
            if (size < capacity) {
                size++;
                addToHead(n);
            } else {
                cacheMap.remove(tail.previous.key);
                removeNode(tail.previous);
                addToHead(n);
            }
        }

    }




    /*1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
    Output*/

    static class Node {
        int key;
        int value;
        Node previous;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
