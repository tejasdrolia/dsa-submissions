class Solution {
    public void dfs(int n,HashMap<Integer,List<Integer>> graph,boolean[] vis)
    {
        vis[n] = true;
        if(graph.get(n)!=null)
        {
        for(int nbr:graph.get(n))
        {
            if(!vis[nbr])
            dfs(nbr,graph,vis);
        }
        }
    }
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        for(int edge[]:edges)
        {
            int u = edge[0];
            int v = edge[1];
            List<Integer> ll = graph.getOrDefault(u,new ArrayList<>());
            ll.add(v);
            List<Integer> ll2 = graph.getOrDefault(v,new ArrayList<>());
            ll2.add(u);
            graph.put(u,ll);
            graph.put(v,ll2);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0;i<n;i++)
        {
            if(visited[i]==false)
            {
                //dfs
                dfs(i,graph,visited);
                count++;
            }
        }
        return count;
    }
}
