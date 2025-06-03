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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Pair>> hmap = new TreeMap<>();
        traverse(0, root, hmap, 0);
        for(List<Pair> l : hmap.values()) {
            l.sort(Comparator
            .comparingInt((Pair p) -> p.level)
            .thenComparingInt(p -> p.value));
            List<Integer> temp = new ArrayList<>();
            for(Pair p : l) {
                temp.add(p.value);
            }
            res.add(temp);
        }
        return res;
    }

    private void traverse(int sc, TreeNode root, Map<Integer, List<Pair>> hmap, int level) {
        if(root == null) {
            return;
        }
        if(!hmap.containsKey(sc)) {
            hmap.put(sc, new ArrayList<>());
        }
        hmap.get(sc).add(new Pair(level, root.val));
        traverse(sc - 1, root.left, hmap, level + 1);
        traverse(sc + 1, root.right, hmap, level + 1);
    }

    class Pair {
        int level;
        int value;
        Pair(int level, int value) {
            this.level = level;
            this.value = value;
        }
    }
}