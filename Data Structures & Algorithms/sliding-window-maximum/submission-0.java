class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        int j = 0;
        while(j!=k)
        {
            pq.add(nums[j]);
            j++;
        }
        int ans[] = new int[nums.length-k+1];
        int idx = 0;
        ans[idx++] = pq.peek();
        while(j!=nums.length)
        {
            pq.remove(nums[i]);
            i++;
            pq.add(nums[j]);
            j++;
            ans[idx++] = pq.peek();
        }
        return ans;
    }
}
