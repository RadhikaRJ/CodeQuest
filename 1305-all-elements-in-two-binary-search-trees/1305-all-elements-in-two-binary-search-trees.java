/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

     List<Integer> tree1Integers = new ArrayList<>();
     List <Integer> tree2Integers = new ArrayList<>();
   

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
       
        inorderTraversal(root1,tree1Integers);
        inorderTraversal(root2,tree2Integers);
        return (tree1Integers.size()==0 && tree2Integers.size()==0)? new ArrayList<>() : mergeValues(tree1Integers,tree2Integers);
     
    }

    public void inorderTraversal(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);

    }

    public List<Integer> mergeValues(List<Integer> list1, List<Integer> list2){
        if(list1.size()==0){
            return list2;
        }
        else if(list2.size()==0){
            return list1;
        }
        else{
            List<Integer> mergedList = new ArrayList<>();
            int size1 = list1.size();
            int size2 = list2.size();
            int i=0,j=0;
            while(i<size1 && j<size2){
                if(list1.get(i)<=list2.get(j)){
                    mergedList.add(list1.get(i));
                    i++;
                }
                else{
                     mergedList.add(list2.get(j));
                    j++;
                }
            }

            while(i<size1){
                mergedList.add(list1.get(i));
                i++;
            }

            while(j<size2){
                mergedList.add(list2.get(j));
                j++;
            }

            return mergedList;


        }
        

    }
        
    
}