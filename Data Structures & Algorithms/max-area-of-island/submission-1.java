class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int dfs(int[][] grid, int x, int y, boolean[][] vis) {
        vis[x][y] = true;

        int area = 1;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx >= 0 && ny >= 0 &&
                nx < grid.length && ny < grid[0].length &&
                grid[nx][ny] == 1 &&
                !vis[nx][ny]) {

                area += dfs(grid, nx, ny, vis);
            }
        }

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1 && !vis[i][j]) {
                    ans = Math.max(ans, dfs(grid, i, j, vis));
                }
            }
        }

        return ans;
    }
}