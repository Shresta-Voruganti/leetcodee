/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode curr = head;
        while(curr != null) {
            curr = deletinghehe(curr, m, n);
        }
        return head;
    }

    private ListNode deletinghehe(ListNode node, int m, int n) {
        ListNode temp = node;
        for(int i = 1; i < m && temp != null; i++) {
            temp = temp.next;
        }

        if(temp == null || temp.next == null) {
            return null;
        }

        ListNode temp2 = temp.next;
        for(int i = 0; i < n && temp2 != null; i++) {
            temp2 = temp2.next;
        }
        temp.next = temp2;
        return temp2;
    }
}