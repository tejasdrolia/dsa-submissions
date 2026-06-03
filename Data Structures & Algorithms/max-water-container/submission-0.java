class Solution {
    public int maxArea(int[] heights) {
        // The idea here is to realise why we are moving the pointer with lower ht and not the pointer with higher value.
        // look at summet sir video

        int i = 0;
        int j = heights.length-1;
        int max = 0;
        while(i<j)
        {
            int cval = (j-i)*Math.min(heights[i],heights[j]);
            max = Math.max(cval,max);
            if(heights[i]<heights[j])
            i++;
            else
            j--;
        }
        return max;
    }
}
