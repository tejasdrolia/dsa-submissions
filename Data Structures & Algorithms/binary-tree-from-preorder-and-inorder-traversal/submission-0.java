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
    public TreeNode dfs(int[] pre, int[] in,int psi,int pei, int isi, int iei)
    {
        if(psi>pei || isi>iei)
        return null;
        TreeNode node = new TreeNode(pre[psi]);
        int idx = 0;
        for(int i = isi;i<=iei;i++)
        {
            if(in[i] == pre[psi])
            {idx = i;
            break;}
        }
        int diff = idx-isi;
        //for left subtree -> psi+1, psi+1+diff , isi,idx-1
        node.left = dfs(pre,in,psi+1,psi+1+diff,isi,idx-1);
        //for right subtree -> psi+1+diff+1,pei , idx+1,iei;
        node.right = dfs(pre,in,psi+diff+1,pei,idx+1,iei);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
}
