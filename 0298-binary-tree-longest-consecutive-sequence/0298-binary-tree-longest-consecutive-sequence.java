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
        traverse(root, 0, root != null ? root.val - 1 : 0);
        return maxlen;
    }

    private void traverse(TreeNode node, int currlen, int parentval) {
        if(node == null ) {
            return;
        }

        if(node.val == parentval + 1) {
            currlen++;
        }
        else {
            currlen = 1;
        }

        maxlen = Math.max(maxlen, currlen);

        traverse(node.right, currlen, node.val);
        traverse(node.left, currlen, node.val);
    }
}