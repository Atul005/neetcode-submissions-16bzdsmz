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
    public void reorderList(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(prev == null){
            return;
        }

        prev.next = null;
        ListNode head2 = slow;

        ListNode temp = head2;
        ListNode prev2 = null;

        while(temp != null){
            ListNode next = temp.next;
            temp.next = prev2;
            prev2 = temp;
            temp = next;
        }

        head2 = prev2;


        boolean flag = true;
        while(head != null && head2 != null){
            if(flag){
                ListNode next = head.next;
                head.next = head2;
                head = next;
            }else{
                ListNode next = head2.next;
                head2.next = head;
                head2 = next;
            }
            flag = !flag;

            // ListNode node1 = head.next;
            // ListNode node2 = head2.next;

            // head.next = head2;
            // head2.next = node1;

            // head = node1;
            // head2 = node2;

        }

    }
}
