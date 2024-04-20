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
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        //process children node before root to determine if their contribution should be included
        //post order traversal
        gainFromSubTree(root);
        return maxSum;
    }

    public int gainFromSubTree(TreeNode root){
        if(root==null){
            return 0;
        }

        int gainFromLeft = Math.max(0,gainFromSubTree(root.left));
        int gainFromRight = Math.max(0,gainFromSubTree(root.right));
      

        maxSum = Math.max(maxSum,root.val+gainFromLeft+gainFromRight);
       
       return Math.max(gainFromLeft+root.val, gainFromRight+root.val);

    }
}