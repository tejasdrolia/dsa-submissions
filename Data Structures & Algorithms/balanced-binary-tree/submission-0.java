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
    boolean flag = true;
    public int ht(TreeNode node)
    {
        if(!flag)
        return -1;
        if(node==null)
        return 0;
        int l = ht(node.left);
        int r = ht(node.right);
        if(Math.abs(l-r)>1)
        flag = false;
        return Math.max(l,r)+1;
    }
    public boolean isBalanced(TreeNode root) {
        flag = true;
        ht(root);
        return flag;
    }
}
