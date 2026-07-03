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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null || left == right){
            return head;
        }

        ListNode temp = head;
        ListNode prev = null;

        int count  = 1;
        while(temp != null && count != left){
            prev = temp;
            temp = temp.next;
            count++;
        }

        ListNode leftEnd = temp;
        ListNode prev1 = null;

        while(count <= right){
            ListNode next = temp.next;
            temp.next = prev1;
            prev1 = temp;
            temp = next;
            count++;
        }

        if(prev != null){
            prev.next = prev1;
        }else{
            head = prev1;
        }

        leftEnd.next = temp;
        return head;
    }
}