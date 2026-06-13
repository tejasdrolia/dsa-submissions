class Solution {
    public int[] countBits(int n) {
        int ans[] = new int[n+1];
        ans[0] = 0;
        for(int i = 1;i<=n;i++)
        {
            int count = 0;
            for(int j = 0;j<32;j++)
            {
                int num = 1<<j;
                if((num & i) !=0)
                count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}
