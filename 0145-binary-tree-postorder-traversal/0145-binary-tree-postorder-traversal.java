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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        postorder(root, arr);
        return arr;
    }

    public void postorder(TreeNode root, List<Integer> arr) {
        if(root == null) {
            return;
        }
        postorder(root.left, arr);
        postorder(root.right, arr);
        arr.add(root.val);
    }
}