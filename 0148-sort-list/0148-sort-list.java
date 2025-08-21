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
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        ListNode head1 = null;
        ListNode tail = null;
        Map<Integer, Integer> hmap = new TreeMap<>();
        ListNode p1 = head;
        while(p1 != null) {
            hmap.put(p1.val, hmap.getOrDefault(p1.val, 0) + 1);
            p1 = p1.next;
        }
        
        for(Map.Entry<Integer, Integer> e : hmap.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();
            
            for(int i = 0; i < val; i++) {
                ListNode temp = new ListNode(key);
                if(head1 == null) {
                    head1 = temp;
                    tail = head1;
                }
                else {
                    tail.next = temp;
                    tail = tail.next;
                }
            }
        }

        return head1;
    }
}