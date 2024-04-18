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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;

        ListNode result = new ListNode(-1);
        ListNode current = result;

       while(l1!=null && l2!=null){
        sum = l1.val+l2.val+carry;
        if(sum>9){
            carry = 1;
            sum = sum%10;
        }
        else{
            carry =0;
        }

        ListNode newListNode = new ListNode(sum);
        current.next = newListNode;
        current = current.next;
        l1 = l1.next;
        l2 = l2.next;
       }

       while(l1!=null){
        sum = l1.val+carry;
        if(sum>9){
            sum = sum%10;
            carry = 1;
        }
        else{
            carry = 0;
        }
        ListNode newListNode = new ListNode(sum);
        current.next = newListNode;
        l1=l1.next;
        current = current.next;
       }

       while(l2!=null){
        sum = l2.val+carry;
        if(sum>9){
            sum=sum%10;
            carry=1;
        }
        else
        {
            carry=0;
        }
         ListNode newListNode = new ListNode(sum);
        current.next = newListNode;
        l2 = l2.next;
        current = current.next;
       }

       if(carry == 1){
        ListNode newListNode = new ListNode(1);
        current.next = newListNode;
        current = current.next;
       }

       return result.next;

       


    }
}