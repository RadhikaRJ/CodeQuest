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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next==null) {
            return head;
        }

        if(head.next!=null && head.next.next==null){
            return head;
        }
        ListNode headTwo = head.next;
        ListNode p1 = head;
        ListNode p2 = head.next;
        
        /**
         * 2,  1,  3,  5,  6,  4,  7
         *                   p2   p1
         * 
         * 2->3->6->7
         * 1->5->4->null
         *
         * 1.  1
         * 
         */
        while (p1 != null ) {
            if(p2.next!=null){
                p1.next = p2.next;
            }
            

            p1 = p1.next;

            if (p1 != null ) {
                p2.next = p1.next;
            }
          
            p2 = p2.next;

           
            if(p1.next==null || p2.next==null){
               
                break;
            }

        }
       
       /* if(p2!=null && p2.next!=null){
            p1.next = p2.next;
            p1=p1.next;
            p2.next =null;
        }
*/
        
       p1.next=headTwo;

      

        return head;

    }
}