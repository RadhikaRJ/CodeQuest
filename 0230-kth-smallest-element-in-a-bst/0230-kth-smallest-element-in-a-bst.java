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
    Stack<Integer> stack = new Stack<>();
    public int kthSmallest(TreeNode root, int k) {
        int n = k;
        inorderTraversal(root,n);
        return stack.pop();
    }

    public void inorderTraversal(TreeNode root, int k){
        if(root==null){
            return;
        }
        inorderTraversal(root.left, k);
        if(stack.size()<k){
            stack.push(root.val);
        }
        inorderTraversal(root.right,k);
    }
}