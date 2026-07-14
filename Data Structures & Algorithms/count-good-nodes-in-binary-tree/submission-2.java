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
    int ans = 0;
    public void dfs(TreeNode node,int max)
    {
        if(node==null)
        return;
        if(node.val>=max)
        {
            ans++;
            max = node.val;
        }
        dfs(node.left,max);
        dfs(node.right,max);
    }
    public int goodNodes(TreeNode root) {
        // basically call the both sides of tree and keep updateing the maximum, if the maximum is updated
        // then it means that we found a good node
        dfs(root,-101);
        return ans;
    }
}
