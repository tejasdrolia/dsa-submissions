class Solution {
    public int largestRectangleArea(int[] ar) {
        int dpr[] = new int[ar.length];
        int dpl[] = new int[ar.length];
        Stack<Integer> nser = new Stack<>();
        Stack<Integer> nsel = new Stack<>();
        dpr[ar.length-1] = ar.length;
        nser.push(ar.length-1);
        for(int i = ar.length-2;i>=0;i--)
        {
            while(nser.size()>0 && ar[nser.peek()]>=ar[i])
            nser.pop();
            if(nser.size()==0)
            dpr[i] = ar.length;
            else
            dpr[i] = nser.peek();
            nser.push(i);
        }

        dpl[0] = -1;
        nsel.push(0);
        for(int i = 1;i<ar.length;i++)
        {
            while(nsel.size()>0 && ar[nsel.peek()]>=ar[i])
            nsel.pop();
            if(nsel.size()==0)
            dpl[i] = -1;
            else
            dpl[i] = nsel.peek();
            nsel.push(i);
        }

        int max = 0;
        for(int i = 0;i<ar.length;i++)
        {
            max = Math.max(max,(dpr[i] - dpl[i]-1)*ar[i]);
        }
        return max;
    }
}
