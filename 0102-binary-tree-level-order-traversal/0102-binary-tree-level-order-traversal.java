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
        List<List<Integer>> result = new ArrayList<>();
        levelord(root, 0, result);
        return result;
    }

    private void levelord(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;

        // If we are entering a new level for the first time
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

        // Add the current node's value to the appropriate level
        result.get(level).add(node.val);

        // Recur for left and right children
        levelord(node.left, level + 1, result);
        levelord(node.right, level + 1, result);
    }
}