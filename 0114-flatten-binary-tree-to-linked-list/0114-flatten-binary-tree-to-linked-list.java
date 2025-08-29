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
    List<Integer> list;
    public void flatten(TreeNode root) {
        if(root == null) return;
        list = new ArrayList<>();
        preorder(root);
        // root.left = null;
        // root.right = null;
        TreeNode curr = root;
        curr.val = list.get(0);
        curr.left = null;
        for(int i = 1; i < list.size(); i++) {
            int val = list.get(i);
            TreeNode node = new TreeNode(val);
            // root.right = node;
            curr.right = node;
            curr.left = null;
            curr = node;
        }
    }

    private void preorder(TreeNode root) {
        if(root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}