class Solution {
    // cycle detection by dsu
    int[] rank;
    int[] parent; 
    public int[] findRedundantConnection(int[][] edges) {
        rank = new int[edges.length+1];
        parent = new int[edges.length+1];
        for(int i = 1;i<rank.length;i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }

        //union
        for(int[]edge:edges)
        {
            int x = edge[0];
            int y = edge[1];
            int lx = find(x);
            int ly = find(y);
            if(parent[lx]==parent[ly]) // cycle is formed by this edge
            return edge;
            if(rank[lx]>rank[ly])
            {
                parent[ly] = lx;
            }
            else if(rank[lx]<rank[ly])
            {
                parent[lx] = ly;
            }
            else
            {
                parent[lx] = ly;
                rank[ly]++;
            }
        }
        return new int[2];
    }

    public int find(int x)
    {
        if(parent[x] == x)
        return x;
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
}
