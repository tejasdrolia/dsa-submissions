class Solution {
    class Pair {
        int x;
        int y;
        int wt;
        Pair(int x, int y, int wt) {
            this.x = x;
            this.y = y;
            this.wt = wt;
        }
    }
    int dirs[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        // bsf

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    q.add(new Pair(i, j, 0));
            }
        }
        while(q.size()>0)
        {
            Pair rem = q.remove();
            int x = rem.x;
            int y = rem.y;
            if(grid[x][y]==(Math.pow(2,31)-1) || grid[x][y] == 0)
            {
                grid[x][y] = rem.wt;
                for(int dir[]:dirs)
                {
                    int nx = x+dir[0];
                    int ny = y+dir[1];
                    if(nx>=0 && ny>=0 && nx<grid.length && ny<grid[0].length && grid[nx][ny] == (Math.pow(2,31)-1))
                    {
                        q.add(new Pair(nx,ny,rem.wt+1));
                    }
                }
            }
        }
    }
}
