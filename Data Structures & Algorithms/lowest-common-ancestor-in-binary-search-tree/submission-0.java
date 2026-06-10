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
    public void path(TreeNode root, TreeNode node, ArrayList<TreeNode> ar) {
        if (node.val > root.val)
            path(root.right, node, ar);
        else if (node.val < root.val)
            path(root.left, node, ar);
        else {
            ar.add(root);
            return;
        }
        ar.add(root);
        return;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> al1 = new ArrayList<>();
        ArrayList<TreeNode> al2 = new ArrayList<>();
        path(root, p, al1);
        path(root, q, al2);
        int i = al1.size() - 1;
        int j = al2.size() - 1;
        TreeNode ans = null;
        // for (TreeNode x : al1) {
        //     System.out.print(x.val+" ");
        // }
        // System.out.println();
        // for (TreeNode x : al2) {
        //     System.out.print(x.val+" ");
        // }
        // System.out.println();

        while (i >= 0 && j >= 0) {
            if (al1.get(i) == al2.get(j)) {
                ans = al1.get(i);
                i--;
                j--;
            } else {
                break;
            }
        }
        return ans;
    }
}
