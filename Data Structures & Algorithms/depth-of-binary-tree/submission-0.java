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
    public int ht(TreeNode node, int val)
    {
        if(node == null)
        return 1;
        int rt = ht(node.right,val+1);
        int lft = ht(node.left,val+1);
        return Math.max(rt,lft)+1;
    }
    public int maxDepth(TreeNode root) {
        return ht(root,0)-1;
    }
}
