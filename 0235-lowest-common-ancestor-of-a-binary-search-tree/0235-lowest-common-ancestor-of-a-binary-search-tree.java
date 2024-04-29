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
        findLCAInBST(root, p, q);
        return lca;
    }

    public void findLCAInBST(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == p || root == q){
            lca = root;
            return;
        }
        else 
        {
            if(root.val >= p.val && root.val<=q.val ||  root.val>=q.val && root.val<=p.val){
                lca = root;
                return;
            }
            else if(root.val>p.val && root.val > q.val){
                findLCAInBST(root.left, p, q);
            }
            else{
                findLCAInBST(root.right, p, q);
            }

        
        }
    }
}

    /**
    Basic search alse works here (without binary search conditions)
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p,q);
        return lca;
    }

    public boolean findLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }

        int left = findLCA(root.left, p,q) ? 1 : 0;
        int right = findLCA(root.right, p,q)? 1 : 0;
        int mid = (root == p || root == q)?1:0;
        if(mid+left+right >=2){
            lca = root;
        }

        return (mid+left+right > 0);
    }
    
    
    
     */
