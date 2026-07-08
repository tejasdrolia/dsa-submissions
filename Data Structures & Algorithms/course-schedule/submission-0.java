class Solution {
    public boolean canFinish(int n, int[][] arr) {
        //step 1 : create graph
        HashMap<Integer,List<Integer>> graph = new HashMap<>();

        // step 2: create indegree
        int indegree[] = new int[n];
        for(int ar[]:arr)
        {
            int u = ar[0];
            int v = ar[1];
            List<Integer> l = graph.getOrDefault(u,new ArrayList<>());
            l.add(v);
            graph.put(u,l);
            indegree[v]++;
        }
        // use kahn algo to eliminate nodes with zero indegree successively
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++)
        {
            if(indegree[i] == 0)
            q.add(i);
        }
        while(q.size()!=0)
        {
            int rem = q.remove();
            count++;
            if(graph.get(rem)==null)
            continue;
            for(int nbrs:graph.get(rem))
            {
                indegree[nbrs]--;
                if(indegree[nbrs] == 0)
                q.add(nbrs);
            }
        }
        if(count == n)
        return true;
        return false;
    }
}
