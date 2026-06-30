class Solution {
    // source should have +1 outdegree compared to indegree
    // destination should have +1 indergee compared to outdegree
    List<String> ans;
    HashMap<String,PriorityQueue<String>> graph;
    public List<String> findItinerary(List<List<String>> tickets) {
        ans = new ArrayList<>();
        graph = new HashMap<>();
        //creation of graph
        for(List<String> ticket:tickets)
        {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            PriorityQueue<String> temp = graph.getOrDefault(src,new PriorityQueue<>());
            temp.add(dest);
            graph.put(src,temp);
        }
        //System.out.println("graph : "+graph);
        dfs("JFK");
        return ans;
    }
    public void dfs(String src)
    {
        PriorityQueue<String> nbrs = graph.get(src);
        while(nbrs!=null && nbrs.size()!=0)
        {
            String ndest = nbrs.remove();
            dfs(ndest);
        }
        ans.addFirst(src);
    }
}
