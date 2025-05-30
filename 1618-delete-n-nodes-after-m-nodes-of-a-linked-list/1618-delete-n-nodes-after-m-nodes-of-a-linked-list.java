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
        while(m > 1 && temp != null) {
            temp = temp.next;
            m--;
        }

        if(temp == null || temp.next == null) {
            return null;
        }

        ListNode temp2 = temp.next;
        while(n > 0 && temp2 != null) {
            temp2 = temp2.next;
            n--;
        }
        temp.next = temp2;
        return temp2;
    }
}