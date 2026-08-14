class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int parent[] = new int[n+1];
        int rank[] = new int[n+1];
        for(int i = 0;i<n+1;i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
        for(int []edge:edges)
        {
            int x = edge[0];
            int y = edge[1];
            int parentX = find(x,parent);
            int parentY = find(y,parent);
            if(parentX == parentY)
            return edge;
            if(rank[parentX]>rank[parentY])
            {
                parent[parentY] = parentX;
            }
            else if(rank[parentY]>rank[parentX])
            {
                parent[parentX] = parentY;
            }
            else
            {
                parent[parentX] = parentY;
                rank[parentY]++;
            }
        }
        return new int[2];
    }
    private int find(int x,int parent[])
    {
        if(parent[x] == x)
        return x;
        int temp = find(parent[x],parent);
        parent[x] = temp;
        return temp;
    }
}
