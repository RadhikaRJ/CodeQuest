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
    int maxDiameterLength = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculateDiameter(root);
        return maxDiameterLength-1;
    }

    public int calculateDiameter(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }

        int leftDiameter = 1+calculateDiameter(root.left);
        maxDiameterLength = Math.max(maxDiameterLength,leftDiameter);
        int rightDiameter = 1+calculateDiameter(root.right);
        maxDiameterLength = Math.max(maxDiameterLength,rightDiameter)-1;
        maxDiameterLength = Math.max(maxDiameterLength,leftDiameter+rightDiameter-1);
        return Math.max(leftDiameter,rightDiameter);

    }
}