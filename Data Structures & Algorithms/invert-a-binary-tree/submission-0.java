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
    public TreeNode dfs(TreeNode node)
    {
        if(node==null)
        return null;
        TreeNode nnode = new TreeNode();
        nnode.val = node.val;
        nnode.right = dfs(node.left);
        nnode.left = dfs(node.right);
        return nnode;
    }
    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }
}
