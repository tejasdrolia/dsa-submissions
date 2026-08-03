class Solution {
    private class Pair implements Comparable<Pair> {
        char ch;
        int freq;
        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
        public int compareTo(Pair p) {
            return p.freq-this.freq;
        }
    }
    public String reorganizeString(String s) {
        int fmap[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            fmap[ch - 97]++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < 26; i++) {
            if (fmap[i] > 0)
                pq.add(new Pair(((char) (97 + i)), fmap[i]));
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            Pair p1 = pq.remove();
            Pair p2 = pq.remove();
            sb.append(p1.ch);
            sb.append(p2.ch);
            p1.freq--;
            p2.freq--;

            if (p1.freq > 0)
                pq.add(new Pair(p1.ch, p1.freq));
            if (p2.freq > 0)
                pq.add(new Pair(p2.ch, p2.freq));
        }
        if (pq.size() > 0) {
            Pair p = pq.remove();
            if (p.freq > 1)
                return "";
            sb.append(p.ch);
        }
        return sb.toString();
    }
}