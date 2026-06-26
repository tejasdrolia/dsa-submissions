class Solution {
    class Pair 
    {
        int x;
        int y;
        int time;
        Pair(int x,int y, int time)
        {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int count = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i<grid.length;i++)
        {
            for(int j = 0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 1)
                {
                    count++;
                }
                if(grid[i][j] == 2)
                {
                    q.add(new Pair(i,j,0));
                }
            }
        }
        //bfs
        int dirs[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        int fans = 0;
        while(q.size()!=0)
        {
            int size = q.size();
            while(size-->0)
            {
                Pair rem = q.remove();
                fans = rem.time;
                for(int dir[]:dirs)
                {
                    int nx = dir[0] + rem.x;
                    int ny = dir[1] + rem.y;
                    if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny] == 1)
                    {
                        q.add(new Pair(nx,ny,rem.time+1));
                        grid[nx][ny] = 2;
                        count--;
                    }
                }
            }
        }
        if(count==0)
        return fans;
        return -1;

    }
}
