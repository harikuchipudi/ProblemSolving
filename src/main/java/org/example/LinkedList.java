package org.example;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {

    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addNode(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    public void deleteNode(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }

        if (temp.next == null) return;

        temp.next = temp.next.next;
    }

    public void reverse() {
        if (head == null) return;

        Node prev = null;
        Node curr = head;
        Node temp;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        head = prev;
    }

    public Node revereKNodes(Node curr_head, int k) {
        if (curr_head == null || countNodes(curr_head) < k) {
            return curr_head;
        }

        Node prev = null;
        Node curr = curr_head;
        Node temp_next = null;

        int count = 0;
        while (curr != null && count < k) {
            temp_next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp_next;
            count++;
        }

        curr_head.next = revereKNodes(temp_next, k);

        return prev;
    }

    public int countNodes(Node temp) {
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? " --> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 5; i++) {
            linkedList.addNode(i + 1);
        }
        System.out.println("Original List:");
        linkedList.printList();

        linkedList.reverse();
        System.out.println("Reversed List:");
        linkedList.printList();

        linkedList.head = linkedList.revereKNodes(linkedList.head, 2);
        System.out.println("Reversed in Groups of 2:");
        linkedList.printList();
    }
}
