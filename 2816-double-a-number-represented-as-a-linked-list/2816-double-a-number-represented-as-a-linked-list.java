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
    int sum = 0, carry = 0;
    public ListNode doubleIt(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode node = recursiveCalc(sentinel);
       if(carry == 0){
        return node.next;
       }
       node.val = node.val+carry;
       return sentinel;


    }

    private ListNode recursiveCalc(ListNode head){
        if(head == null){
            return head;
        }

       ListNode current = recursiveCalc(head.next);
       if(current!=null){
        int doubledVal = current.val*2;
        sum = doubledVal%10;
      
        current.val = sum+carry;
        carry = doubledVal/10;
        sum=0;

       

       }
        return head;
    }
}