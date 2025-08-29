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
        int l = lists.length;
        ListNode list = new ListNode(-1);
        ListNode tail = list;

        while(true) {
            int minvalue = Integer.MAX_VALUE;
            int minindex = -1;

            for(int i = 0; i < l; i++) {
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

        return list.next;
    }
}