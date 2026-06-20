class KthLargest {
    PriorityQueue<Integer> pq;
    int k1;
    public KthLargest(int k, int[] nums) {
        k1 = k;
        pq = new PriorityQueue<>();
        for(int i:nums)
        pq.add(i);
        while(pq.size()>k)
        pq.remove();
    }
    
    public int add(int val) {
        if(pq.size()<k1)
        pq.add(val);
        else if(pq.peek()<=val)
        {
            pq.add(val);
            pq.remove();
        }
        return pq.peek();
    }
}
