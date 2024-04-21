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
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root,root);
    }

    public boolean checkSymmetric(TreeNode root1, TreeNode root2){
        if(root1==null && root2 == null){
            return true;
        }
        if((root1==null && root2!=null)||(root1!=null && root2==null)){
            return false;
        }

        if(root1.left!=null && root2.right!=null && root1.left.val!=root2.right.val){
            return false;
        }

        if(root1.right!=null && root2.left!=null && root1.right.val!=root2.left.val){
            return false;
        }
        return checkSymmetric(root1.left,root2.right) && checkSymmetric(root1.right,root2.left);
    }
}