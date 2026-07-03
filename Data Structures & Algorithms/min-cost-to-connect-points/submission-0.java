class Solution {
    public class Pair implements Comparable<Pair>
    {
        int x;
        int y;
        int dis;
        int idx;
        Pair(int x,int y,int dis,int idx)
        {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.idx = idx;
        }
        public int compareTo(Pair p)
        {
            return this.dis - p.dis;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int ans = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(points[0][0],points[0][1],0,0));
        boolean vis[] = new boolean[points.length];
        while(pq.size()!=0)
        {
            Pair p = pq.remove();
            
            if(vis[p.idx])
            continue;
            vis[p.idx] = true;
            ans+=p.dis;
            for(int i = 0;i<points.length;i++)
            {
                if(vis[i]==false)
                {
                    int x = points[i][0];
                    int y = points[i][1];
                    int dis = Math.abs(x-p.x) + Math.abs(y-p.y);
                    pq.add(new Pair(x,y,dis,i));
                }
            }
        }
        return ans;
    }
}