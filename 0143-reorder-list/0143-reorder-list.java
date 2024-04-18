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

 /**
 head = 1;
 1->2
 3->4--> reverse this list : 4->3

 1->2

 l1
 4->3
 l2

1-2-3
l1
4->5
l2

1->4->2->5
   l1

[1,2,3,5,4]


 



1->2


  */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){ //1->2->3 => 1-3>2
            return;
        }
        //1. divide in half
        ListNode slow = head;
        ListNode fast = head.next;

        //1->2->3->4->5->null
        //s. f
        //.  s     f
        //.     s.       f
        //.        h2
        //.       3->null
        //

       
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next; //3
        slow.next =null;

        //2. reverse 2nd half of list
        ListNode list2 = reverseList(head2);
        // ListNode pointer = list2;
        // while(pointer!=null){
        //     System.out.println(pointer.val);
        //     pointer = pointer.next;
        // }


        //3. ReOrder them
 /**
        
       
  */
        ListNode list1 = head;

        //list1  = [1,2,3]
        //list2  = [5,4]
       
        while(list2!=null){
          ListNode temp = list1.next;  //temp =2 //temp =3
          list1.next = list2; //list1= 1, 1->5 //2->4
          list2=list2.next;//list2= [4] //null
          list1 = list1.next;//list1=>5, list1=4
          list1.next = temp;//5->2->3// 4->3
          list1=list1.next;//
           //1->5->2->3 //1st iteration
           //list1 = 2
           //list2 =4

        }

      


    }

    private ListNode reverseList(ListNode head){ //1->2->3
        if(head == null || head.next == null){
            return head ;
        }

        ListNode current = reverseList(head.next); //current = 3, head =2
        head.next.next = head ;// 2->3->2
        head.next = null; // 3->2
        return current;

    }


}