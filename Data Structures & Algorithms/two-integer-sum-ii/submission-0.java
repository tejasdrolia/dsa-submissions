class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while(i<j)
        {
            int x = numbers[i] + numbers[j];
            if(target<x)
            {
                j--;
            }
            else if(target>x)
            {
                i++;
            }
            else
            {
                return new int[]{i+1,j+1};
            }
        }
        return new int[]{-1,-1};
    }
}
