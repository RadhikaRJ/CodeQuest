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
        ListNode start = head;
        ListNode end = head;
        int k = n;

        if(head.next == null && n ==1){
            return null;
        }

        
        while(k>0){
            end = end.next;
            k--;
        }

        while(end!= null && end.next!=null){
           start = start.next;
           end = end.next;
        }

        start.next = start.next.next;
        return head;



    }
}