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
    public List<Integer> preorderTraversal(TreeNode root) {
        //Inorder Traversal: left, root, right
        //Preorder Traversal: Root, left, right
        //Postorder Traversal:left, right, root

        getPreorderTraversal(root);
        return result;

    }

    public void getPreorderTraversal(TreeNode root){
        if(root == null){
            return;
        }

       result.add(root.val);
       getPreorderTraversal(root.left);
       getPreorderTraversal(root.right);


    }
}