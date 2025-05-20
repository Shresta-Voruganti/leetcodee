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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int mid = low + (high - low)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if(mid - 1 >= low) {
            root.left = createTree(low, mid - 1, nums);
        }
        if(mid + 1 <= high) {
            root.right = createTree(mid + 1, high, nums);
        }
        return root;
    }

    private TreeNode createTree(int low, int high, int[] nums) {
        if(low > high) {
            return null;
        }
        int mid = low + (high - low)/2;
        TreeNode node = new TreeNode(nums[mid]);
 
        if(mid - 1 >= low) {
            node.left = createTree(low, mid - 1, nums);
        }
        if(mid + 1 <= high) {
            node.right = createTree(mid + 1, high, nums);
        }
        return node;
    }
}