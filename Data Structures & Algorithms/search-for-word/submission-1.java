class Solution {
    // you cannot apply levels and options everywhere
    int dirs[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    public boolean dfs(char[][] board, String word, int idx,int i, int j,boolean[][] vis)
    {
        if(idx==word.length())
        {
            return true;
        }
        for(int dir[]:dirs)
        {
            int nx = i+dir[0];
            int ny = j+dir[1];
            if(nx<board.length && ny<board[0].length &&  nx>=0 && ny>=0 && !vis[nx][ny] && board[nx][ny] == word.charAt(idx))
            {
                vis[nx][ny] = true;
                if(dfs(board,word,idx+1,nx,ny,vis))
                return true;
                vis[nx][ny] = false;
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        boolean vis[][] = new boolean[board.length][board[0].length];
        for(int i = 0;i<board.length;i++)
        {
            for(int j = 0;j<board[0].length;j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    vis[i][j] = true;
                    boolean b = dfs(board,word,1,i,j,vis);
                    if(b)
                    return true;
                    vis[i][j] = false;
                }
            }
        }
        return false;
    }
}
