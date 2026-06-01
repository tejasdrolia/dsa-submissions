class Solution {
    class Pair implements Comparable<Pair>
    {
        int num;
        int freq;
        Pair(int num,int freq)
        {
            this.num = num;
            this.freq = freq;
        }
        public int compareTo(Pair p)
        {
            if(this.freq>=p.freq)
            return -1;
            else
            return 1;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int key:map.keySet())
        {
            pq.add(new Pair(key, map.get(key)));
        }
        int ans[] = new int[k];
        for(int i = 0;i<k;i++)
        {
            ans[i] = pq.remove().num;
        }
        return ans;
    }
}
