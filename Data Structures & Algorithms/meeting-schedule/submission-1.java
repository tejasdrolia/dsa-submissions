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
        int st;
        int end;
        Pair(int st,int end)
        {
            this.st = st;
            this.end = end;
        }
        public int compareTo(Pair p)
        {
            return this.st - p.st;
        }
    }
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size()==0)
        return true;
        Pair ar[] = new Pair[intervals.size()];
        for(int i = 0;i<intervals.size();i++)
        {
            ar[i] = new Pair(intervals.get(i).start,intervals.get(i).end);
        }
        Arrays.sort(ar);
        int st = ar[0].st;
        int end = ar[0].end;
        for(int i = 1;i<ar.length;i++)
        {
            int tst = ar[i].st;
            int tend = ar[i].end;
            if(tst < end)
            return false;
            st = tst;
            end = tend;
        }
        return true;
    }
}
