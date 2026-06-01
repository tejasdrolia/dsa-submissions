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
            return 1;
            else
            return -1;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int i = 0;
        for(int key:map.keySet())
        {
            if(i<k)
            {
                pq.add(new Pair(key,map.get(key)));
            }
            else
            {
                if(pq.peek().freq<=map.get(key))
                {
                    pq.remove();
                    pq.add(new Pair(key,map.get(key)));
                }
            }
            i++;
        }
        int ans[] = new int[k];
        int idx = 0;
        while(pq.size()!=0)
        {
            ans[idx++] = pq.remove().num;
        }
        return ans;
    }
}
