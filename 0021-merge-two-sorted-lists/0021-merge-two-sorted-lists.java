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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return list1;
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode head1 = list1;
        ListNode head2 = list2;

        ListNode p1 = head1;
        ListNode p2 = head2;

        ListNode head3 = null;
        ListNode tail = null;


        // while(p1.next != null || p2.next != null) {
        //     if(p1.val < p2.val) {
        //         head3 = p1;
        //         p1 = p1.next;
        //     }
        //     else {
        //         head3 = p2;
        //         p2 = p2.next;
        //     }
        //     head3.next = 
        // }    

        while(p1 != null || p2 != null) {
            if(p1 != null && (p2 == null || p1.val < p2.val)) {
                if(head3 == null) {
                    head3 = p1;
                    tail = head3;
                }
                else {
                    tail.next = p1;
                    tail = tail.next;
                }
                p1 = p1.next;
            }
            else {
                if(head3 == null) {
                    head3 = p2;
                    tail = head3;
                }
                else {
                    tail.next = p2;
                    tail = tail.next;
                }
                p2 = p2.next;
            }
        }

        return head3;
    }
}