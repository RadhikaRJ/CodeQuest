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
    int diameterLength = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int val = findDiameter(root);
        return diameterLength==Integer.MIN_VALUE?0:diameterLength;
    }

    public int findDiameter(TreeNode root){

        /**         4
                2       5
         */
        if(root==null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        int leftPathLength = findDiameter(root.left); //fd(2)=1
        int rightPathLength = findDiameter(root.right); //fd(5)=1

        int pathWithRoot = leftPathLength+rightPathLength;  //2

        diameterLength = Math.max(diameterLength, leftPathLength); //2
        diameterLength = Math.max(diameterLength, rightPathLength);//2
        diameterLength = Math.max(diameterLength, pathWithRoot);//2
  
        
        return 1+Math.max(leftPathLength,rightPathLength); //1
    }
}


            //             2
            //         1       3
            //     4       7
            // 5               8
            //                     9
            //                         10
        

