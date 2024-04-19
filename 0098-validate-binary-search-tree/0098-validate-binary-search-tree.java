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

 /**
 leftTree
keep track of recent most max val =>5
        5
    1
0       9

 5-> max
 root.left --> 1
 1<5, leftTree = True

 root.left
 
 
 5<-min
 root.right -> 4 

            5
                6
            2      3

 
 
  */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        if(root.left == null && root.right == null){ //root =5
            return true;
        }

        
        //left BST, parent root > 5 > all subtrees
        //right BST, parent 5 < all right subTree

        int globalMax = Integer.MAX_VALUE;
        int globalMin = Integer.MIN_VALUE;


  return recursiveCheck(root, globalMax, globalMin); // subtree 1=> true
       // subtree 4 => false

        
    

    } 

    public boolean recursiveCheck(TreeNode root, int globalMax, int globalMin){ //subtree1 = true
        //5                             2
    //1.       //4                  7.       2
//0.   //9.   3.    6
    //subtree 4
        if(root==null){
            return true;
        }

        if(root.val >= globalMax || root.val <= globalMin){
            return false;
        }
      
      
        boolean left = recursiveCheck(root.left, root.val, globalMin); //t -> l;eft 2 subtre
        boolean right = recursiveCheck(root.right, globalMax, root.val); // t



        return left && right;

       
    }
}