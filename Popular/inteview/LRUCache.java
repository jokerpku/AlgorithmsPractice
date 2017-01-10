package inteview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jokeria on 2017/1/9.
 */
class DLinkedNode {
    int key;
    int value;
    DLinkedNode next;
    DLinkedNode pre;
}

public class LRUCache {

    private int count;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;
    private Map<Integer, DLinkedNode> map;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        map = new HashMap<Integer, DLinkedNode>();

        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            DLinkedNode node = new DLinkedNode();
            node.value = value;
            node.key = key;
            if(count == capacity) {
                DLinkedNode tail = popTail();
                map.remove(tail.key);
                count--;
            }
            map.put(key, node);
            addNode(node);
            count++;
        }
    }


    protected void addNode(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;

        node.next.pre = node;
        head.next = node;
    }

    protected void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    protected void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    protected DLinkedNode popTail() {
        DLinkedNode node = tail.pre;
        removeNode(node);

        return node;
    }
}
