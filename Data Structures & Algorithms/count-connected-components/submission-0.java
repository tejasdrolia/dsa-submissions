class Solution {
    public int countComponents(int n, int[][] edges) {
        //create graph.
        int ans = 0;
        ArrayList<Integer> [] graph = new ArrayList[n];
        for(int i = 0;i<n;i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[v].add(u);
            graph[u].add(v);
        }
        boolean vis[] = new boolean[n];
        for(int i = 0;i<n;i++)
        {
            if(vis[i]==false)
            {
                dfs(graph,vis,i);
                ans++;
            }
            
        }
        return ans;
    }
    public void dfs(ArrayList<Integer> graph[],boolean vis[],int u)
    {
        vis[u] = true;
        for(int nbrs = 0;nbrs<graph[u].size();nbrs++)
        {
            if(vis[graph[u].get(nbrs)] == false)
            dfs(graph,vis,graph[u].get(nbrs));
        }
    }
}
