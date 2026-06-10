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
    int kk = 0;
    int fans = 0;
    public void  help(TreeNode root)
    {
        if(kk==0)
        {
            fans = ans;
            return;
        }
        if(root==null)
            return;
        
        help(root.left);
        kk--;
        ans = root.val;
        help(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        ans = 0;
        kk = k;
        fans = 0;
        help(root);
        return fans;
        
    }
}

