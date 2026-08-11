class Solution {
    public int[] asteroidCollision(int[] ar) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<ar.length;i++)
        {
            if(ar[i]>0)
            st.push(ar[i]);
            else
            {
                while(st.size()>0 && st.peek()>0 && Math.abs(ar[i])>st.peek())
                {
                    st.pop();
                }
                if(st.size() !=0 && Math.abs(ar[i]) == st.peek())
                {
                    st.pop();
                    continue;
                }
                if(st.size() ==0 || st.peek()<0)
                {
                    st.push(ar[i]);
                    continue;
                }
            }
        }
        int ans[] = new int[st.size()];
        int idx = ans.length-1;
        int size = st.size();
        while(size-->0)
        {
            ans[idx--] = st.pop();
        }
        return ans;
    }
}