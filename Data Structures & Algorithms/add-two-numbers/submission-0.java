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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;
        while(l1!=null && l2!=null)
        {
            int sum = l1.val+l2.val+carry;
            carry = sum/10;
            int digit = sum%10;
            ListNode nnode = new ListNode(digit);
            l1 = l1.next;
            l2 = l2.next;
            temp.next = nnode;
            temp = temp.next;
        }
        while(l1!=null)
        {
            int sum = l1.val+carry;
            carry = sum/10;
            int digit = sum%10;
            ListNode nnode = new ListNode(digit);
            l1 = l1.next;
            temp.next = nnode;
            temp = temp.next;
        }
        while(l2!=null)
        {
            int sum = l2.val+carry;
            carry = sum/10;
            int digit = sum%10;
            ListNode nnode = new ListNode(digit);
            l2 = l2.next;
            temp.next = nnode;
            temp = temp.next;
        }
        if(carry!=0)
        {
            ListNode node = new ListNode(carry);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }
}
