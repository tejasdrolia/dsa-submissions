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
    ListNode ans = null;
    int max = 0;
    public void dfs(ListNode node,int count)
    {
        if(node==null)
        return;
        count = count+1;
        max = Math.max(max,count);
        dfs(node.next,count);
        if(count>max/2)
        {
        node.next = ans.next;
        ans.next = node;
        ans = node.next;
        }
    }
    public void reorderList(ListNode head) {
        ans = head;
        dfs(head,0);
        ans.next = null;
    }
}
