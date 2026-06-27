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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode slow = head;
        ListNode prev  = null;

        if(head == null){
            return head;
        }

        while(n > 0 && temp != null){
            n--;
            temp = temp.next;
        }

        while(temp != null){
            prev = slow;
            slow = slow.next;
            temp = temp.next;
        }

        if(prev == null){
            return slow.next;
        }

        prev.next = slow.next;

        return head;
    }
}
