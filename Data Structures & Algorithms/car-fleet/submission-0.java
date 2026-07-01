class Solution {
    public class Pair implements Comparable<Pair>
    {
        int loc;
        int speed;
        Pair(int loc,int speed)
        {
            this.loc = loc;
            this.speed = speed;
        }
        public int compareTo(Pair p)
        {
            return this.loc - p.loc;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        Pair ar[] = new Pair[speed.length];
        for(int i = 0;i<speed.length;i++)
        {
            ar[i] = new Pair(position[i],speed[i]);
        }
        Arrays.sort(ar);
        Stack<Double> st = new Stack<>();
        st.push((target - ar[ar.length-1].loc)/(ar[ar.length-1].speed*1.0));
        for(int i = ar.length-2;i>=0;i--)
        {
            double ttd = ((target-ar[i].loc)/(ar[i].speed*1.0));
            if(st.size()>0 && st.peek()>=ttd)
            {

            }
            else
            {
                st.push(ttd);
            }
        }
        return st.size();
    }
}
