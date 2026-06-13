class Solution {
    public class Pair implements Comparable<Pair>
    {
        int st;
        int end;
        Pair(int st,int end)
        {
            this.st = st;
            this.end = end;
        }
        public int compareTo(Pair p)
        {
            if(this.st == p.st)
            return this.end - p.end;
            return this.st - p.st;
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Pair ar[] = new Pair[intervals.length];
        for(int i = 0;i<intervals.length;i++)
        {
            ar[i] = new Pair(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(ar);
        Stack<Pair> st = new Stack<>();
        int rem = 0;
        for(int i = ar.length-1;i>=0;i--)
        {
            if(st.size()==0)
            st.push(ar[i]);
            else
            {
                if(st.peek().st<ar[i].end)
                {
                    rem++;
                    continue;
                }
                st.push(ar[i]);
            }
        }
        return rem;
    }
}
