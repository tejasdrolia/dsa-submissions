class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
    {
        int[] path=new int[n];
        Arrays.fill(path,Integer.MAX_VALUE);
        path[src]=0;
        for(int i=0;i<=K;i++)
        {
            int[] temp= path.clone();
            for(int[] f: flights)
            {
                int curr=f[0],next=f[1],price=f[2];
                if(path[curr]==Integer.MAX_VALUE)
                    continue;
                temp[next]=Math.min(temp[next],path[curr]+price);
            }
            path=temp;
        }
        return path[dst]==Integer.MAX_VALUE?-1:path[dst];
    }
}