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
    int sum = 0;
    public int findTilt(TreeNode root) {
        calculateTilt(root);
        return sum;
    }

    public int calculateTilt(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.val;
        }
        
        int leftSubTreeSum = root.val+calculateTilt(root.left);
        int rightSubTreeSum = root.val+calculateTilt(root.right);
        sum = sum + Math.abs(leftSubTreeSum - rightSubTreeSum);

        return leftSubTreeSum+rightSubTreeSum-root.val;
    }
}