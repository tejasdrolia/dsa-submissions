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
    public TreeNode dfs(TreeNode root, int val)
    {
        if(root==null)
        {
            TreeNode node = new TreeNode(val);
            return node;
        }
        if(val>root.val)
        root.right = dfs(root.right,val);
        else
        root.left = dfs(root.left,val);
        return root;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return dfs(root,val);
    }
}