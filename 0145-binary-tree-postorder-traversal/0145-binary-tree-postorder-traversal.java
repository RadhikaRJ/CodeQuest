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
    public List<Integer> postorderTraversal(TreeNode root) {
        //Inorder Traversal: left, root, right
        //Preorder Traversal: Root, left, right
        //Postorder Traversal:left, right, root

        performPostorderTraversal(root);
        return result;
    }

    public void performPostorderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        performPostorderTraversal(root.left);
        performPostorderTraversal(root.right);
        result.add(root.val);

    }
}