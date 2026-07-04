class Solution {
    int dirs[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    public void dfs(char[][] board,int i,int j)
    {
        board[i][j] = 'T';
        for(int dir[]:dirs)
        {
            int nx = dir[0] + i;
            int ny = dir[1] + j;
            if(nx>=0 && ny>=0 &&nx<board.length && ny<board[0].length &&board[nx][ny] == 'O')
            {
                dfs(board,nx,ny);
            }
        }
    }
    public void solve(char[][] board) {
        // in this question we have to not capture any 'O' on edges and anything that is linked with it.
        for(int i = 0;i<board.length;i++)
        {
            for(int j = 0;j<board[0].length;j++)
            {
                if(i ==0 || j==0 || i==board.length-1 || j==board[0].length-1)
                {
                    if(board[i][j]=='O')
                    {
                        dfs(board,i,j);
                    }
                }
            }
        }

        for(int i = 0;i<board.length;i++)
        {
            for(int j = 0;j<board[0].length;j++)
            {
                if(board[i][j] == 'O')
                board[i][j] = 'X';
                if(board[i][j] =='T')
                board[i][j] = 'O';
            }
        }
    }
}
