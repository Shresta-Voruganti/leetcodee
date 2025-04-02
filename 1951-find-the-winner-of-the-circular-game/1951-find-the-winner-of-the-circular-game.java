class Solution {
    public int findTheWinner(int n, int k) {
        CircularLinkedList ll = new CircularLinkedList();
        for(int i = 1; i <= n; i++) {
            ll.add(i);
        }

        int index = 0;
        while(ll.getSize() > 1) {
            index = (index + k - 1) % ll.getSize();
            ll.removeAt(index);
        }

        int survivor = ll.getHead();
        return survivor;
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head = null;
    Node tail = null;
    int size = 0;

    public void add(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        }
        else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }

    public void removeAt(int index) {
        if (head == null || size == 0) {
            return;
        }

        if (size == 1) { // If only one element is left
            head = null;
            tail = null;
            size = 0;
            return;
        }

        Node temp = head;
        Node prev = tail;

        if (index == 0) { // Removing the first element
            head = head.next;
            tail.next = head;
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (temp.next == head) { // If tail was removed, update tail
                tail = temp;
            }
        }
        size--;
    }

    public int getSize() {
        return size;
    }

    public int getHead() {
        return head.data;
    }
}