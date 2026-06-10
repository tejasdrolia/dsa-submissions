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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
        return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while(q.size()!=0)
        {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            while(size-->0)
            {
                //remove
                TreeNode rem = q.remove();
                temp.add(rem.val);
                if(rem.left!=null)
                q.add(rem.left);
                if(rem.right!=null)
                q.add(rem.right);
            }
            ans.add(temp);
        }
        return ans;
    }
}
