class Solution {

    class Pair implements Comparable<Pair> {
        int val;
        ListNode li;

        Pair(int val, ListNode li) {
            this.val = val;
            this.li = li;
        }

        public int compareTo(Pair p) {
            return this.val - p.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(new Pair(lists[i].val, lists[i]));
            }
        }

        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while (!pq.isEmpty()) {

            Pair p = pq.remove();

            temp.next = p.li;
            temp = temp.next;

            if (p.li.next != null) {
                pq.add(new Pair(p.li.next.val, p.li.next));
            }
        }

        return dummy.next;
    }
}