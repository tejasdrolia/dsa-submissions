class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int parent[] = new int[n+1];
        int rank[] = new int[n+1];

        for(int i = 0;i<n;i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge:edges)
        {
            int p1 = find(edge[0],parent);
            int p2 = find(edge[1],parent);
            if(p1 == p2)
            return edge;
            else
            {
                if(rank[p1]>rank[p2]) // union by size/rank
                {
                    parent[p2] = p1;
                }
                else if(rank[p2]>rank[p1])
                {
                    parent[p1] = p2;
                }
                else
                {
                    parent[p1] = p2;
                    rank[p2]++;
                }
            }
        }
        return new int[2];

    }
    private int find(int x,int[] parent)
    {
        if(parent[x] == x)
        return x;
        int temp = find(parent[x],parent);
        parent[x] = temp; // path compression
        return temp;
    }
}
