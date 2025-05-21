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
    int count;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }
        helper(root, targetSum);
        return count;
    }

    private void helper(TreeNode root, int targetSum) {
        if(root == null) {
            return;
        }
        sumCalc(root, targetSum * 1L);
        helper(root.left, targetSum);
        helper(root.right, targetSum);
    }

    private void sumCalc(TreeNode root, long targetSum) {
        if(root == null) {
            return;
        }

        if(root.val == targetSum) {
            count++;
        }

        sumCalc(root.left, targetSum - root.val);
        sumCalc(root.right, targetSum - root.val);
    }
}