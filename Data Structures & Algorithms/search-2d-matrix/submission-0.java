class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;
        while(i<matrix.length && j>=0)
        {
            int cnum = matrix[i][j];
            if(target>cnum)
            {
                i++;
            }
            else if(target<cnum)
            {
                j--;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}
