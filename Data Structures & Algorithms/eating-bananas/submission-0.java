class Solution {
    public boolean check(int val,int[] ar,int h)
    {
        int x = 0;
        for(int i:ar)
        {
            if(i%val == 0)
            x+=(i/val);
            else
            x+=(i/val)+1;
        }
        if(x<=h)
        return true;
        return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int r = piles[0];
        for(int i:piles)
        r = Math.max(r,i);
        int l = 1;
        int possibleans = -1;
        while(l<=r)
        {
            int mid = (l+r)/2;
            boolean b = check(mid,piles,h);
            if(b)
            {
                possibleans = mid;
                r = mid-1;
            }
            else
            {
                l = mid+1;
            }
        }
        return possibleans;
    }
}
