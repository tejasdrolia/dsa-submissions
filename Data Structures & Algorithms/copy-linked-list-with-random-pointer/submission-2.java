/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
        return null;
        HashMap<Node,Node> map = new HashMap<>();
        Node n = head;
        while(n!=null)
        {
            map.put(n,new Node(n.val)); 
            n = n.next;
        }
        n = head;
        while(n!=null)
        {
            Node ndash = map.get(n);
            ndash.next = map.get(n.next);
            ndash.random = map.get(n.random);
            n = n.next;
        }
        return map.get(head);
    }
}
