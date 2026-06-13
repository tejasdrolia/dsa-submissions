class Solution {
    public class Pair{
        int x;
        int y;
        Pair(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public void setZeroes(int[][] matrix) {
        Queue<Pair> q = new LinkedList<>();
        boolean [] rows = new boolean[matrix.length];
        boolean [] col = new boolean[matrix[0].length];
        for(int i = 0;i<matrix.length;i++)
        {
            for(int j = 0;j<matrix[0].length;j++)
            {
                if(matrix[i][j] == 0)
                q.add(new Pair(i,j));
            }
        }
        while(q.size()!=0)
        {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            if(rows[x]==false)
            {
                for(int j = 0;j<matrix[0].length;j++)
                {
                    matrix[x][j] = 0;
                }
                rows[x] = true; 
            }
            if(col[y] == false)
            {
                for(int i = 0;i<matrix.length;i++)
                {
                    matrix[i][y] = 0;
                }
                col[y] = true; 
            }
        }
    }
}