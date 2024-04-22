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
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        
        checkBalance(root);
        return balanced;
    }

    public int checkBalance(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftMaxHeight = checkBalance(root.left);
        int rightMaxHeight = checkBalance(root.right);

        int diff = Math.abs(leftMaxHeight - rightMaxHeight);

        if(diff>1){
            balanced = false;
        }
        return 1+Math.max(leftMaxHeight, rightMaxHeight);
    }


}