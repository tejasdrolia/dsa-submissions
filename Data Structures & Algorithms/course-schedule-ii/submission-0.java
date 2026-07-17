class Solution {
    public int[] findOrder(int n, int[][] arr) {
        // kahn algo
        int indegree[] = new int[n];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] ar : arr) {
            int u = ar[0]; // 1
            int v = ar[1]; // 0
            List<Integer> l = graph.get(v);
            l.add(u);
            graph.put(v, l);
            indegree[u]++;
        }
        int ans[] = new int[n];
        int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        while (q.size() != 0) {
            int rem = q.remove();
            ans[idx++] = rem;
            for (int i : graph.get(rem)) {
                indegree[i]--;
                if (indegree[i] == 0)
                    q.add(i);
            }
        }
        if (idx != n)
            return new int[0];

        return ans;
    }
}
