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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // Single node or empty list is always a palindrome
        }

        // Step 1: Find the middle of the linked list
        ListNode middle = getMid(head);
        
        // Step 2: Reverse the second half
        ListNode secondHalfStart = reverse(middle.next);
        ListNode temp = secondHalfStart; // Store for restoration
        middle.next = null; // Split the list

        // Step 3: Compare the two halves
        ListNode head1 = head;
        ListNode head2 = secondHalfStart;
        boolean isPalindrome = true;

        while (head2 != null) {
            if (head1.val != head2.val) {
                isPalindrome = false;
                break;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        // Step 4: Restore the original list
        middle.next = reverse(temp);

        return isPalindrome;
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) { 
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Slow is at the middle
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev; // New head of the reversed list
    }
}
    // public boolean isPalindrome(ListNode head) {
    //     // if(head == null || head.next == null) { //single node in LL
    //     //     return true;
    //     // }

    //     // ListNode middleEle = getMid(head);
    //     // ListNode secondHalfStart = reverse(middleEle.next);
    //     // middleEle.next = secondHalfStart;

    //     // ListNode head1 = head;
    //     // ListNode head2 = secondHalfStart;
    //     // boolean ispalidn = true;

    //     // while(head2 != null) {
    //     //     if(head1.val != head2.val) {
    //     //         ispalidn = false;
    //     //         break;
    //     //     }
    //     //     head1 = head1.next;
    //     //     head2 = head2.next;
    //     // }

    //     // middleEle = reverse(secondHalfStart);
    //     // return ispalidn;

    //     // if (head == null || head.next == null) {
    //     //     return true; // A single node or empty list is a palindrome
    //     // }

    //     // // Step 1: Find the middle of the linked list
    //     // ListNode middle = getMid(head);
        
    //     // // Step 2: Reverse the second half of the linked list
    //     // ListNode secondHalfStart = reverse(middle.next);
    //     // middle.next = null; // Split the list into two halves

    //     // // Step 3: Compare the two halves
    //     // ListNode head1 = head;
    //     // ListNode head2 = secondHalfStart;
    //     // boolean isPalindrome = true;

    //     // while (head2 != null) {
    //     //     if (head1.val != head2.val) {
    //     //         isPalindrome = false;
    //     //         break;
    //     //     }
    //     //     head1 = head1.next;
    //     //     head2 = head2.next;
    //     // }

    //     // // Step 4: Restore the original list (optional)
    //     // middle.next = reverse(secondHalfStart); // Restore the original list

    //     // return isPalindrome;

    //     if (head == null || head.next == null) {
    //         return true; // Single node or empty list is always a palindrome
    //     }

    //     // Step 1: Find the middle of the linked list
    //     ListNode middle = getMid(head);
        
    //     // Step 2: Reverse the second half
    //     ListNode secondHalfStart = reverse(middle.next);
    //     ListNode temp = secondHalfStart; // Store for restoration
    //     middle.next = null; // Split the list

    //     // Step 3: Compare the two halves
    //     ListNode head1 = head;
    //     ListNode head2 = secondHalfStart;
    //     boolean isPalindrome = true;

    //     while (head2 != null) {
    //         if (head1.val != head2.val) {
    //             isPalindrome = false;
    //             break;
    //         }
    //         head1 = head1.next;
    //         head2 = head2.next;
    //     }

    //     // Step 4: Restore the original list
    //     middle.next = reverse(temp);

    //     return isPalindrome;
    // }

    // private ListNode getMid(ListNode head) {
    //     // ListNode slow = head;
    //     // ListNode fast = head;
    //     // while(fast.next != null) {
    //     //     slow = slow.next;
    //     //     if(fast.next.next == null) {
    //     //         break;
    //     //     }
    //     //     fast = fast.next.next;
    //     // }
    //     // return slow;
    //     ListNode slow = head;
    //     ListNode fast = head;
    //     while (fast != null && fast.next != null) {
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }
    //     return slow; // Slow will be at the middle
    // }

    // private ListNode reverse(ListNode head) {
    //     // if(head == null || head.next == null) {
    //     //     return head; // Base case: if only one node, return as is
    //     // }

    //     // ListNode newHead = reverse(head.next); // Recursively reverse the rest of the list

    //     // head.next.next = head; // Reverse the link (make next node point to current)
    //     // head.next = null;      // Disconnect the old link

    //     // return newHead; // Return the new head of the reversed list

    //     // Node prev = null;
    //     // Node curr = head;
    //     // Node next;

    //     // while (curr != null) {
    //     //     next = curr.next;  // Store next node
    //     //     curr.next = prev;   // Reverse the link
    //     //     prev = curr;        // Move prev to current
    //     //     curr = next;        // Move to next node
    //     // }

    //     // return prev; // New head of reversed list

    //     ListNode prev = null;
    //     ListNode curr = head;
    //     while (curr != null) {
    //         ListNode nextTemp = curr.next; // Store next node
    //         curr.next = prev;               // Reverse the link
    //         prev = curr;                    // Move prev to current
    //         curr = nextTemp;                // Move to next node
    //     }
    //     return prev; // New head of the reversed list
    // }
