class Solution {
    public class Pair implements Comparable<Pair>
    {
        int x;
        int t;
        Pair(int x,int t)
        {
            this.x = x;
            this.t = t;
        }
        public int compareTo(Pair p)
        {
            return p.x - this.x;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int ar[] = new int[26];
        for(char ch:tasks)
        ar[ch-65]++;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:ar)
        {
            if(i!=0)
            pq.add(i);
        }
        Queue<Pair> q = new LinkedList<>();
        int t = 0;
        while(pq.size()>0 || q.size()>0)
        {
            t++;
            if(q.size()>0 && q.peek().t == t)
            {
                pq.add(q.remove().x);
            }
            if(pq.size()>0)
            {
                int rem = pq.remove();
                rem--;
                if(rem !=0)
                q.add(new Pair(rem,t+n+1));
            }
        }
        return t;
    }
}
