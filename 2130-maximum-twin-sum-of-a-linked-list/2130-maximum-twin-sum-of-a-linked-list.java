/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        // [6,5,4,
        // 3,2,1]
        // 1,2,3]
        // [6+1,5+2,4+3]

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newhead = slow.next;
        slow.next = null;

        ListNode reversedHead = reverseList(newhead);

        int maxTwinSum = Integer.MIN_VALUE;

        ListNode pointerOne = head;
        ListNode pointerTwo = reversedHead;

        while (pointerOne != null && pointerTwo != null) {
            maxTwinSum = Math.max(maxTwinSum, pointerOne.val + pointerTwo.val);
            pointerOne = pointerOne.next;
            pointerTwo = pointerTwo.next;
        }

        return maxTwinSum;

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;

    }
}
