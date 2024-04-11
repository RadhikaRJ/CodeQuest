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
    ListNode newHead = null;
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        reverse(head);
        head.next = null;
        return newHead;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode nextNode = reverse(head.next);
        if (nextNode != null) {
            nextNode.next = head; 
        } else {
            newHead = head;
        }
        return head;
    }
}