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
    int maxans = 0;
    public int dfs(TreeNode node)
    {
        if(node==null)
        return 0;
        int r = dfs(node.right);
        int l = dfs(node.left);
        maxans = Math.max(maxans,r+l+1);
        return Math.max(l,r)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
        return 0;
        int ans = dfs(root);
        return Math.max(ans,maxans)-1;
    }
}
