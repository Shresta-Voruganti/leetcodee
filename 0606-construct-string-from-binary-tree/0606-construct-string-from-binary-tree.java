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
    static StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        if(root == null) {
            return "";
        }
        sb.setLength(0);
        preorder(root);
        return sb.toString();
    }

     private void preorder(TreeNode t) {
        if(t == null) {
            return;
        }
        sb.append(t.val);

        if(t.left != null || t.right != null) {
            sb.append("(");
            preorder(t.left);
            sb.append(")");
        }
        
        if(t.right != null) {
            sb.append("(");
            preorder(t.right);
            sb.append(")");
        }
    }
}