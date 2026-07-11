class LRUCache {
    Node head;
    Node tail;
    public class Node {
        Node next;
        Node prev;
        int key;
        int val;
        Node(int key,int val) {
            this.val = val;
            this.key = key;
        }
    }
    HashMap<Integer, Node> map;
    int cap;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    public void delete(Node node)
    {
        Node prv = node.prev;
        Node nxt = node.next;
        prv.next = nxt;
        nxt.prev = prv;
        node.next = null;
        node.prev = null;

    }
    public void insertAtFront(Node cnode)
    {
        cnode.next = head.next;
        cnode.prev = head;
        head.next.prev = cnode;
        head.next = cnode;
        
    }
    public int removeAtLast()
    {
        Node rem = tail.prev;
        delete(rem);
        return rem.key;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);

        // Move to front
        delete(node);
        insertAtFront(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node cnode = map.get(key);
            cnode.val = value;
            delete(cnode);
            insertAtFront(cnode);
        } else {
            
            if (map.size() >= cap) {
                int key1 = removeAtLast();
                map.remove(key1);
            }
            Node nnode = new Node(key,value);
            insertAtFront(nnode);
            map.put(key, nnode);
        }
    }
}
