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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prevNode = null;
        ListNode nextNode = null;

        if(temp == null || k<= 0){
            return temp;
        } 

        ListNode kthNode = null;
        
        while(temp != null){
            if(temp != null){
                kthNode = findKthNode(temp, k);
            }  

            if(kthNode == null){
                if(prevNode == null){
                    return head;
                }else{
                    prevNode.next = temp;
                    break;
                }
            }

            nextNode = kthNode.next;
            kthNode.next = null;

            ListNode reversedHead = reverse(temp);

            if(prevNode == null){
                head = reversedHead;
            }else{
                prevNode.next = reversedHead;
            }

            temp.next = nextNode;
            prevNode = temp;
            temp = nextNode;
        }

        return head;

    }

    ListNode findKthNode(ListNode temp, int k){
        while(--k > 0 && temp != null){
            temp = temp.next;
        }
        return temp;
    }

    ListNode reverse(ListNode node){
        ListNode temp = node;
        ListNode prev = null;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

}
