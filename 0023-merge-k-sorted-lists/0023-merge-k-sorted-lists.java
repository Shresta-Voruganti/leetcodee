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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(true) {
            int minindex = -1;
            int minvalue = Integer.MAX_VALUE;

            for(int i = 0; i < lists.length; i++) {
                if(lists[i] != null && lists[i].val < minvalue) {
                    minvalue = lists[i].val;
                    minindex = i;
                }
            }

            if(minindex == -1) {
                break;
            }

            tail.next = lists[minindex];
            tail = tail.next;

            lists[minindex] = lists[minindex].next;
        }

        return dummy.next;
    }
}