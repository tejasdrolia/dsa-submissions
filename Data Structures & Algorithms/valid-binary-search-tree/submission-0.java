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
    public class Pair
    {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        boolean isBST = true;
    }
    public Pair help(TreeNode root)
    {
        //faith
        if(root==null)
        {
            Pair mp = new Pair();
         //   mp.max = root.val;
         //   mp.min = root.val;
            return mp;
        }
        Pair l = help(root.left);
        Pair r = help(root.right);
        Pair mp = new Pair();
        mp.max = Math.max(l.max,Math.max(r.max,root.val));
        mp.min = Math.min(l.min,Math.min(r.min,root.val));
        //mp.isBST???
        if(l.isBST && r.isBST && l.max<root.val && r.min>root.val)
            mp.isBST = true;
        else
            mp.isBST = false;
        return mp;
    }
    public boolean isValidBST(TreeNode root) {
        // if(root==null)
        //     return false;
        if(root.left==null && root.right==null)
            return true;
        Pair p = help(root);
        return p.isBST;
    }
}