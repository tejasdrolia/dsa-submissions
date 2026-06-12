/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        HashMap<Node,Node> map = new HashMap<>();// Will help in storing new nodes corresponding to existing node;
        map.put(node,new Node(node.val));
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(q.size()!=0)
        {
            Node p = q.remove();
            for(Node neighbors:p.neighbors)
            {
                if(!map.containsKey(neighbors))
                {
                    map.put(neighbors,new Node(neighbors.val));
                    q.add(neighbors);
                }
                map.get(p).neighbors.add(map.get(neighbors));
            }
        }
        return map.get(node);
    }
}