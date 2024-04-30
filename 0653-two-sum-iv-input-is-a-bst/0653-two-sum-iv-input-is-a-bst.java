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
    boolean pairExists = false;
    public boolean findTarget(TreeNode root, int k) {
       Set<Integer> set = new HashSet<>();
        traverseBST(root,k,set);
        return pairExists;
        
    }

    public void traverseBST(TreeNode root, int k, Set<Integer> set){
        if(root == null){
            return;
        }

        if(set.contains(k-root.val)){
            pairExists = true;
            return;
        }
        else{
            set.add(root.val);
            traverseBST(root.left, k, set);
            traverseBST(root.right, k, set);
        }




    }
}