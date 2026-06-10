/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode merge2LL(ListNode l1, ListNode l2)
    {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode ans = new ListNode();
        ListNode temp = ans;
        while(t1!=null && t2!=null)
        {
            if(t1.val < t2.val)
            {
                ans.next = t1;
                t1 = t1.next;
            }
            else
            {
                ans.next = t2;
                t2 = t2.next;
            }
            ans = ans.next;
        }
        if(t1!=null)
        ans.next = t1;
        if(t2!=null)
        ans.next = t2;
        return temp.next;
    }
    public ListNode merge(ListNode[] lists,int si,int ei)
    {
        if(si==ei)
        return lists[si];
        if(si>ei)
        return null;
        int mid = (si+ei)/2;
        ListNode l1 = merge(lists,si,mid);
        ListNode l2 = merge(lists,mid+1,ei);
        return merge2LL(l1,l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }
}
