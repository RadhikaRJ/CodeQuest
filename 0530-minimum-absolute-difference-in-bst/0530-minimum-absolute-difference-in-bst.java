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
    List<Integer> inorderValues = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        //use inorder traversal to traverse the tree in increasing order of values
        inorderTraversal(root);

        int min = Integer.MAX_VALUE;
        for(int i=1;i<inorderValues.size();i++){
            min = Math.min(min,inorderValues.get(i)-inorderValues.get(i-1) );
        }
        return min;
    }

    public void inorderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        inorderTraversal(root.left);
        inorderValues.add(root.val);
        inorderTraversal(root.right);
    }
}