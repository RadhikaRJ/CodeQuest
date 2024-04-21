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
  
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return findMaxDepth(root); 
    }

    public int findMaxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
       
        int maxLeft = 1+ findMaxDepth(root.left);
        int maxRight = 1+ findMaxDepth(root.right);
        return Math.max(maxLeft,maxRight);
    }
}