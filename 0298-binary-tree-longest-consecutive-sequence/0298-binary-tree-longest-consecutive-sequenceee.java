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
    int maxlen = 0;
    public int longestConsecutive(TreeNode root) {
        traverse(root, null, 0);
        return maxlen;
    }

    private void traverse(TreeNode node, TreeNode parent, int currlen) {
        if(node == null) {
            return;
        }

        if(parent != null && node.val == parent.val + 1) {
            currlen++;
        }
        else {
            currlen = 1;
        }

        maxlen = Math.max(maxlen, currlen);

        traverse(node.right, node, currlen);
        traverse(node.left, node, currlen);
    }
}
