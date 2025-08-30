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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode start = head;

        while(true) {
            int count = 0;
            ListNode check = start;
            while(count < k && check != null) {
                check = check.next;
                count++;
            }

            if(count < k) {
                break;
            }

            ListNode blockStart = start;
            ListNode blockNext = check;

            ListNode newhead = reverseBlock(blockStart, k);

            prev.next = newhead;
            blockStart.next = blockNext;

            prev = blockStart;
            start = blockNext;
        }

        return dummy.next;
    }

    private ListNode reverseBlock(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode nex = null;

        while(k-- > 0) {
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }

        return prev;
    }
}