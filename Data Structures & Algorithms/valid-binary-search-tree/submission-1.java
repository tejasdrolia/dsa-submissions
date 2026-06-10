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
    class Pair
    {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        boolean isBST;
        // Pair(int max,int min,boolean isBST)
        // {
        //     this.max = max;
        //     this.min = min;
        //     this.isBST= isBST;
        // }
    }
    public Pair help(TreeNode root)
    {
        if(root==null)
        {
            Pair mp = new Pair();
            mp.isBST = true;
            return mp;
        }
        Pair l = help(root.left);
        Pair r = help(root.right);
        Pair mp = new Pair();
        mp.max = Math.max(root.val,Math.max(l.max,r.max));
        mp.min = Math.min(root.val,Math.min(l.min,r.min));
        if(l.max<root.val && r.min>root.val && l.isBST && r.isBST)
        mp.isBST = true;
        else
        mp.isBST = false;
        return mp;
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null)
        return true;
        return help(root).isBST;
    }
}
