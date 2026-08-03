class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 0;
        for(int i:piles)
        {
            hi = Math.max(hi,i);
        }
        int ans = hi;
        while(lo<=hi)
        {
            int mid = lo+(hi-lo)/2;
            boolean flag = isPossible(piles,h,mid);
            if(flag)
            {
                ans = mid;
                hi = mid-1;
            }
            else
            {
                lo = mid+1;
            }
        }
        return ans;
    }
    private boolean isPossible(int[] piles,int h,int val)
    {
        int count = 0;
        for(int i:piles)
        {
            count+=(i/val);
            if(i%val!=0)
            count++;
        }
        if(count<=h)
        return true;
        return false;
    }
}
