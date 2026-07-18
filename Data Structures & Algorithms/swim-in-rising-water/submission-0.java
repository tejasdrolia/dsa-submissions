class Solution {
    // the question is nothing but slight modification of dijkstra
    public class Pair implements Comparable<Pair>
    {
        int x;
        int y;
        int msf; // we need this to keep track of maximum value so far
        Pair(int x,int y,int msf)
        {
            this.x = x;
            this.y = y;
            this.msf = msf;
        }
        public int compareTo(Pair p){
        return this.msf - p.msf;}
    }
    public int swimInWater(int[][] grid) {
        int dirs[][] = {{0,1},{1,0},{-1,0},{0,-1}};
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int ans = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0,grid[0][0]));
        while(pq.size()!=0)
        {
            Pair rem = pq.remove();
            if(rem.x == grid.length-1 && rem.y == grid[0].length-1)
            return rem.msf;
            if(vis[rem.x][rem.y])
            continue;
            vis[rem.x][rem.y] = true;
            for(int dir[]:dirs)
            {
                int nx = rem.x+dir[0];
                int ny = rem.y+dir[1];
                if(nx>=0 && ny>=0 && nx<grid.length && ny<grid[0].length && vis[nx][ny] == false)
                {
                    pq.add(new Pair(nx,ny,Math.max(rem.msf,grid[nx][ny])));
                }
            }
        }
        return -1;
    }
}
