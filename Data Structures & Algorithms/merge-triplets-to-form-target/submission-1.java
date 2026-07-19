class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int t1 = target[0];
        int t2 = target[1];
        int t3 = target[2];
        int pans[] = new int[3];
        // pans[0] = triplets[0][0];
        // pans[1] = triplets[0][1];
        // pans[2] = triplets[0][2];

        for(int t[]:triplets)
        {
            if(t[0]>t1 || t[1]>t2 || t[2]>t3)
            continue;
            pans[0] = Math.max(pans[0],t[0]);
            pans[1] = Math.max(pans[1],t[1]);
            pans[2] = Math.max(pans[2],t[2]);
            if(pans[0] == t1 && pans[1] == t2 && pans[2] == t3)
            return true;
        }
        return false;
    }
}
