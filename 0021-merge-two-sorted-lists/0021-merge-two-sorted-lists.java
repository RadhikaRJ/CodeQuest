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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedSortedList = new ListNode(); // mergedSortedList=>(dummy)
        ListNode resultHead = mergedSortedList; //resultHead -> mergedSortedList
       //head1 -> [1,2,4] , head2 -> [1,3,4]
//[1,2,3] []
        if(list1==null && list2!=null){
            return list2;
        }
        if(list2==null && list1!=null){
            return list1;
        }

        if(list1==null && list2==null){
            return list1;
        }

        ListNode mergedPointer = mergedSortedList; //mergedPointer -> [dummy,]

        while(list1!=null && list2!=null){ //list1 -> [1,2,4] , list2 -> [1,3,4]
        //[list1 -> [2,4], list2 -> [1,3,4]
            if(list1.val<=list2.val){
                mergedPointer.next = list1; //mergedPointer[dummy -> 1]
                list1=list1.next;  //[list1 -> [2,4], list2 -> [1,3,4]
            }
            else{
               mergedPointer.next = list2; ////[list1 -> [4], list2 -> [,4]
               list2=list2.next; 
            }
            mergedPointer=mergedPointer.next; //mergedPointer[1->2 ->2->3->4]
            //mergedSortedList => [dummy->1->2->2->3->4]
        }

        while(list1!=null){
            mergedPointer.next = list1;
            list1 = list1.next;
            mergedPointer = mergedPointer.next;
        }

        while(list2!=null){//mergedSortedList => [dummy->1-1->2->3->4->4]
            mergedPointer.next =list2;
            list2 = list2.next;
            mergedPointer = mergedPointer.next;
        }


        return resultHead.next; //1->1->2->3->4->4

    }
}