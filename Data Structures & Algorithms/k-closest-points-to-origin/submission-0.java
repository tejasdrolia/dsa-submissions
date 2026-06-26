class Solution {
    class Pair implements Comparable<Pair>
    {
        int x;
        int y;
        double dis;
        Pair(int x, int y, double dis)
        {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
        public int compareTo(Pair p){
            if(this.dis<p.dis)
            return -1;
            else
            return 1;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int p[]:points)
        {
            double d = Math.sqrt(Math.pow(p[0],2) + Math.pow(p[1],2));
            //System.out.println("x , y , dis "+ p[0] +" "+p[1]+" "+d);
            pq.add(new Pair(p[0],p[1],d));
        }
        int ans[][] = new int[k][2];
        for(int i = 0;i<k;i++)
        {
            Pair p = pq.remove();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }
        return ans;
    }
}
