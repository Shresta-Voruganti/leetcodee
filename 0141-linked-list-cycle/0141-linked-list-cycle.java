/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        Set<ListNode> vis = new HashSet<>();
        while(p1 != null) {
            if(!vis.contains(p1)) {
                vis.add(p1);
                p1 = p1.next;
            }
            else {
                return true;
            }
        }
        return false;
    }
}