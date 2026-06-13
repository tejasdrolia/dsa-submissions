class Solution {
    class Pair implements Comparable<Pair>
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
            return this.st - p.st;   
        }
    }
    public int[][] merge(int[][] intervals) {
        Pair ar[] = new Pair[intervals.length];
        for(int i = 0;i<intervals.length;i++)
        {
            ar[i] = new Pair(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(ar);
        Stack<Pair> st = new Stack<>();
        for(Pair p:ar)
        {
            if(st.size()==0)
            st.push(p);
            else
            {
                if(p.st<=st.peek().end)
                st.peek().end = Math.max(st.peek().end,p.end);
                else
                st.push(p);
            }
        }
        int ans[][] = new int[st.size()][2];
        int k = ans.length-1;
        while(st.size()!=0)
        {
            Pair p = st.pop();
            ans[k][0] = p.st;
            ans[k--][1] = p.end;
        }
        return ans;
    }
}
