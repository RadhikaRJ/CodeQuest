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
    public ListNode swapPairs(ListNode head) {
        //RECURSION
        if(head == null || head.next == null){
            return head;
        } 

        ListNode current = head;
        ListNode nextNode = head.next;

        current.next = swapPairs(nextNode.next);
        nextNode.next = current;

        return nextNode;
      


    }

    /**
    
    ITERATIVE SOLUTTION
      if(head == null || head.next == null){
            return head; //[],[1]
        }

        ListNode current = head; //1->2->3
        ListNode temp = current.next.next; // temp -> 3
      
        head = current.next; //head - >2
        current.next.next = current; // 1->2->1
       
        current.next = temp; //2->1->3
        ListNode prev = current; //1
        current = current.next; // 3->

       
        while(current!=null && current.next!=null){ //2->1->3->4->5->6->7
            temp = current.next.next; // 5 //7
           
            current.next.next = current;  
            prev.next = current.next ;
            current.next = temp; 

            prev = current; 
            current = current.next; 


        }

        return head;
     */
}