class Solution {
    public class Edge
    {
        int u;
        int v;
        int wt;
        Edge(int u,int v,int wt)
        {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }
    public class Pair implements Comparable<Pair>
    {
        int idx;
        int wsf;
        Pair(int idx, int wsf)
        {
            this.idx = idx;
            this.wsf = wsf;
        }
        public int compareTo(Pair p)
        {
            return this.wsf - p.wsf;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        //create graph
        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i = 0;i<n;i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int[] ar:times)
        {
            int u = ar[0];
            int v = ar[1];
            int wt = ar[2];
            graph[u-1].add(new Edge(u-1,v-1,wt));
        }
        int ans = 0;
        k = k-1;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k,0));
        boolean vis[] = new boolean[n];
        while(pq.size()>0)
        {
            Pair rem = pq.remove();
            if(vis[rem.idx]==true)
            continue;
            vis[rem.idx] = true;
            ans =rem.wsf;
            for(Edge nbrs:graph[rem.idx])
            {
                if(vis[nbrs.v]==false)
                {
                    pq.add(new Pair(nbrs.v, nbrs.wt + rem.wsf ));
                }
            }
        }
        for(boolean b:vis)
        if(!b) return -1;
        return ans;
    }
}
