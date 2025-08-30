/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Map<Node, Node> hmap = new HashMap<>();

        Node curr = head;
        Node newHead = new Node(curr.val);
        hmap.put(curr, newHead);
        Node tail = newHead;
        curr = curr.next;

        while(curr != null) {
            Node newNode = new Node(curr.val);
            tail.next = newNode;
            tail = newNode;
            hmap.put(curr, newNode);
            curr = curr.next;
        }

        curr = head;
        
        while(curr != null) {
            hmap.get(curr).random = hmap.get(curr.random);
            curr = curr.next;
        }

        return newHead;
    }
}
