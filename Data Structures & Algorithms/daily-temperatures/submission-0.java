class Solution {
    public class Pair
    {
        int val;
        int idx;
        Pair(int val,int idx)
        {
            this.val = val;
            this.idx = idx;
        }
    }
    public int[] dailyTemperatures(int[] arr) {
        Stack<Pair> st = new Stack<>();
        int ans[] = new int[arr.length];
        ans[ans.length-1] = 0;
        st.push(new Pair(arr[arr.length-1],arr.length-1));
        for(int i = ans.length-2;i>=0;i--)
        {
            int ctemp = arr[i];
            while(st.size()>0 && ctemp>=st.peek().val)
            {
                st.pop();
            }
            if(st.size()==0)
            {
                ans[i] = 0;
            }
            else
            {
                ans[i] = st.peek().idx-i;
            }
            st.push(new Pair(arr[i],i));
        }
        return ans;
    }
}
