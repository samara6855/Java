package com.yssr.linkedlist;

public class LinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.InsertFirst(12);
        list.InsertFirst(1);
        list.InsertFirst(5);
        list.InsertFirst(6);

        list.InsertLast(44);

        list.insert(15, 2);

        list.display();
        System.out.println();
        System.out.println(list.deleteFirst());
        list.display();
        System.out.println();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println();
        System.out.println(list.delete(2));
        list.display();
        System.out.println();
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    private int size;
    private Node head;
    private Node tail;

    public LinkedList() {
        this.size = 0;
    }


    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void InsertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size = size + 1;
    }

    public void insert(int value, int index) {
        if (index == 0) {
            InsertFirst(value);
        }
        if (index == size) {
            InsertLast(value);
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(value, temp.next);
        temp.next = node;

        size++;
    }

    public void InsertLast(int value) {
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        if (tail == null) {
            InsertFirst(value);
        }
        size += 1;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast() {
        if (size <= 1) {
            deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    public int delete(int index) {
        if (index == 0) {
            deleteFirst();
        }
        if (index == size - 1) {
            deleteLast();
        }
        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;


        return val;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }


    public class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
