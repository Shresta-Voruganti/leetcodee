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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode slow = head;
        ListNode fast = head;

        // Maintain two pointers and update one with a delay of n steps.
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
         // If fast is null, it means we have to remove the head node
        if(fast == null) {
            return head.next;
        }

        // You should stop one step earlier, i.e. when fast.next != null. That way slow is at the node just before the one to remove.
        // Move slow until fast reaches the last node
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Now slow is before the node to be deleted
        slow.next = slow.next.next;

        return head;
    }
}