class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> st = new Stack<>();
        for (int[] i : intervals) {
            if (st.size() == 0)
                st.push(i);
            else {
                if (st.peek()[1] >= i[0]) {
                    st.peek()[0] = Math.min(st.peek()[0], i[0]);
                    st.peek()[1] = Math.max(st.peek()[1], i[1]);
                    continue;
                }
                st.push(i);
            }
        }
        int ans[][] = new int[st.size()][2];
        int idx = st.size() - 1;
        while (st.size() != 0) {
            int rem[] = st.pop();
            ans[idx][0] = rem[0];
            ans[idx][1] = rem[1];
            idx--;
        }
        return ans;
    }
}
