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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int levelNumber = 0;
        //if levelNumber%2 == 0 then add child nodes in right to left direction
       // else if levelNumber%2 == 1 then add child nodes in left to right direction

       List<List<Integer>> result = new ArrayList<>();

       if(root == null){
        return result;
       }

       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root); //1
       
       while(!queue.isEmpty()){ //[1]//[3,2]
        int size = queue.size(); //1//2
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<size;i++){ 
            TreeNode current = queue.poll(); 
            if(current.left!=null)
            {
                queue.offer(current.left); 
            } 
            if(current.right!=null)
            {
                queue.offer(current.right); 
            }

            list.add(current.val); //[1]
            
        }

        if(levelNumber % 2 == 1)
        {
            Collections.reverse(list);
        }
        levelNumber++; //1
        result.add(list);//[[1]]

       }

    return result;

}}