/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {

        ListNode temp1 = head1;
        ListNode temp2 = head2;

        int count1 = 0;
        while(temp1 != null){
            count1++;
            temp1 = temp1.next;
        }

        int count2 = 0;
        while(temp2 != null){
            count2++;
            temp2 = temp2.next;
        }

        ListNode big = count1 > count2 ? head1 : head2;
        int diff = Math.abs(count1 - count2);

        temp1 = head1;
        temp2 = head2;
        ListNode small = null;
        if(big == head1){
            small = head2;
        }else{
            small = head1;
        }

        while(diff > 0){
            diff--;
            big = big.next;
        }

        while(big != null && small != null){
            if(big == small){
                return big;
            }
            big = big.next;
            small = small.next;
        }

        return null;
    }
}