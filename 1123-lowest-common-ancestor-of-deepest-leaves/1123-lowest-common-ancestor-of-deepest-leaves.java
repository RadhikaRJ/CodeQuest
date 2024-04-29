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
    TreeNode lca = null;
    int maxDepth = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        this.lca = root;
        findLCADeepestLeaves(root,0);
        return lca;
    }

    public int findLCADeepestLeaves(TreeNode root, int depth){
        maxDepth = Math.max(maxDepth,depth);
        if(root == null){
            return depth;
        }

        int leftDepth = findLCADeepestLeaves(root.left, depth+1);
        int rightDepth = findLCADeepestLeaves(root.right, depth+1);
        if(leftDepth == maxDepth && rightDepth == maxDepth){
            lca = root;

        }

        return Math.max(leftDepth, rightDepth);
    }
}