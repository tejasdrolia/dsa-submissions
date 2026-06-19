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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
        return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()!=0)
        {
            int ph = 0;
            int size = q.size();
            while(size-->0)
            {
                TreeNode rem = q.remove();
                if(rem.left!=null)
                q.add(rem.left);
                if(rem.right!=null)
                q.add(rem.right);
                ph = rem.val;
            }
            ans.add(ph);
        }
        return ans;
    }
}
