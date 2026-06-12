class Solution {
    int dirs[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    public void dfs(char[][] grid, int x, int y, boolean[][] vis)
    {

        for(int[] dir:dirs)
        {
            int nx = x+dir[0];
            int ny = y+dir[1];
            if(nx>=0 && ny>=0 && nx<grid.length && ny<grid[0].length && grid[nx][ny]!='0' && vis[nx][ny]==false)
            {
                vis[nx][ny] = true;
                dfs(grid,nx,ny,vis);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int ans = 0;
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++)
        {
            for(int j = 0;j<grid[0].length;j++)
            {
                if(grid[i][j] =='1' && vis[i][j]==false)
                {
                    vis[i][j] = true;
                    dfs(grid,i,j,vis);
                    ans++;
                }
            }
        }
        return ans;
    }
}
