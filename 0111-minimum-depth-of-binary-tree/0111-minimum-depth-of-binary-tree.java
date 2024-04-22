/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
   

    public int minDepth(TreeNode root) {
        // BFS is better approach as it access fewer nodes than DFS
        //Time complexity is same for both approaches (O(N))
        
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int value = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
           
          

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left == null && current.right == null) {
                    return value;
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            value++;

        }

        return -1;

    }

    // DFS approach:
    /**
     * if(root == null){
     * return 0;
     * }
     * 
     * 
     * if(root.left==null){
     * return 1+ minDepth(root.right);
     * 
     * }
     * if(root.right == null){
     * return 1+minDepth(root.left);
     * }
     * 
     * 
     * 
     * return Math.min(minDepth(root.left),minDepth(root.right))+1;
     * 
     */
}