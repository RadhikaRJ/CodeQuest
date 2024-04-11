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
    /**
    1->2->3->4->5
    head = 4 |3 |2 |1
    node = 5| 5->4 | 5->4->3->null | 5->4->3->2->null
    head.next.next = 4->5->4 | 3->4->3 => 5->4->3->4 | 2->3->2 => 5->4->3->2->3 | 1->2->1=>5->4->3->2->1->2
    head.next=null = 4->null | 5->4 | 5->4->3->null | 5->4->3->2->null|5->4->3->2->1->null
    return node | 5->4 | 5->4->3 | 5->4->3->2 | 5->4->3->2->1->
     */
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode node = reverseList(head.next);
        head.next.next = head; //important concept: 1->2->1
        head.next = null;//2->1->null
        return node;
    }
}