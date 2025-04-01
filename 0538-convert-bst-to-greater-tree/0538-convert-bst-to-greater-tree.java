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
    static int globalsum = 0;
    public TreeNode convertBST(TreeNode root) {
        globalsum = 0;
        Sum(root);
        return root;
    }

    private void Sum(TreeNode root) {
        if(root == null) {
            return;
        }
        Sum(root.right);
        globalsum += root.val;
        root.val = globalsum;
        Sum(root.left);
    }
}