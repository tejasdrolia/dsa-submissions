class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart = 0;
        int colEnd = matrix[0].length-1;
        int tnos = matrix.length * matrix[0].length;
        int nos = 0;
        List<Integer> ans = new ArrayList<>();
        while(rowStart <= rowEnd && colStart<=colEnd && nos<tnos)
        {
            //top-wall
            for(int j = colStart ,i = rowStart;j<=colEnd && nos!=tnos ;j++)
            {
                ans.add(matrix[i][j]);
                
                nos++;
            }
            rowStart++;

            //right-wall
            for(int i = rowStart,j = colEnd ; i<=rowEnd && nos!=tnos ;i++)
            {
                System.out.println(matrix[i][j]);
                ans.add(matrix[i][j]);
                
                nos++;
            }
            colEnd--;

            //bottom-wall
            for(int j = colEnd ,i =rowEnd ;j>=colStart && nos!=tnos;j--)
            {
                ans.add(matrix[i][j]);
                
                nos++;
            }
            rowEnd--;
            
            //left-wall
            for(int i = rowEnd,j = colStart;i>=rowStart && nos!=tnos; i--)
            {
                ans.add(matrix[i][j]);
                
                nos++;
            }
            colStart++;
        }
        return ans;
    }
}