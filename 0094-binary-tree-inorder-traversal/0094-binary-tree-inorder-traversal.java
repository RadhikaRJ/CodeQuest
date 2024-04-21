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
     List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        //Inorder Traversal --> Left, root, right

       
       getInorderTraversal(root);
       return result;
    }

    public void getInorderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            result.add(root.val);
            return;
        }

        getInorderTraversal(root.left);
        result.add(root.val);
        getInorderTraversal(root.right);
        
    }
}