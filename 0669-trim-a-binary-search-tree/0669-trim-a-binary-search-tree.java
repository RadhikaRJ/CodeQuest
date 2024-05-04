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

    public TreeNode trimBST(TreeNode root, int low, int high) {

        //To trim a node, it's value  < low or value > high
        //After trimming a node, its "valid" descendants should remain a descendant
        // Eg, 0 < 1 , so we can trim it, but its right child > 1, so replace root.left with 0.right
        //  similarly, if value of node > high, then root.right = value.left 
        //we need a global prev pointer to point to parent of root element
       
     
        return traverseBST(root, low, high);

        
    }

    public TreeNode traverseBST(TreeNode root, int low, int high){
        if(root == null){
            return root;
        }
        else if(root.val<low ){
           return traverseBST(root.right, low, high);
        }
        else if(root.val > high ){
           return  traverseBST(root.left, low, high);
            
        }
        else{
            root.left =   traverseBST(root.left, low, high);
            root.right =   traverseBST(root.right, low, high);
            return root;
            
        }
      
    }
}