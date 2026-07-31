/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public class Pair implements Comparable<Pair>
    {
        int val;
        char s;
        Pair(int val,char s)
        {
            this.val = val;
            this.s = s;
        }
        public int compareTo(Pair p)
        {
            if(this.val==p.val)
            return p.s - this.s;
            return this.val - p.val;
        }
    }
    public int minMeetingRooms(List<Interval> intervals) {
        Pair ar[] = new Pair[intervals.size()*2];
        int idx = 0;
        for(Interval i:intervals)
        {
            ar[idx++] = new Pair(i.start,'A');
            ar[idx++] = new Pair(i.end,'D'); 
        }
        Arrays.sort(ar);
        int arrivals = 0;
        int dep = 0;
        int max = 0;
        for(Pair p:ar)
        {
            if(p.s==('A'))
            arrivals++;
            else
            dep++;
            max = Math.max(max,arrivals-dep);
        }
        return max;
    }
}
