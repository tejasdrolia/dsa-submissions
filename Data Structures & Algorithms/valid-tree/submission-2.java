class Solution {
    int count;
    public boolean dfs(
        HashMap<Integer, List<Integer>> graph, int cnode, int parent, boolean visited[]) {
        visited[cnode] = true;

        if (graph.get(cnode) != null) {
            for (int nbrs : graph.get(cnode)) {
                if (nbrs == parent)
                    continue;

                if (visited[nbrs])
                    return false;

                if (!dfs(graph, nbrs, cnode, visited))
                    return false;
            }
        }
        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        count = 0;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            List<Integer> l = graph.getOrDefault(u, new ArrayList<>());
            List<Integer> ll = graph.getOrDefault(v, new ArrayList<>());
            l.add(v);
            ll.add(u);
            graph.put(u, l);
            graph.put(v, ll);
        }
        boolean vis[] = new boolean[n];
        if (!dfs(graph, 0, -1, vis))
            return false;
        for (boolean v : vis) {
            if (!v)
                return false;
        }
        return true;
    }
}
