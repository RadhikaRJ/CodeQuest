/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root,p,q);
        return lca;
    }

    public boolean findLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }

        int left = findLCA(root.left, p, q)?1:0;
        int right = findLCA(root.right, p, q)?1:0;
        int mid = (root == p || root == q)?1:0;

        if(mid+right+left >= 2){
            lca = root;
        }

        return (left+right+mid > 0);
    }
}