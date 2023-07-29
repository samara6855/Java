package com.yssr.linkedlist;

public class DoublyLL {

    public static void main(String[] args) {
        DoublyLL list = new DoublyLL();
        list.insertFirst(5);
        list.insertFirst(1);
        list.insertFirst(11);
        list.insertFirst(6);
        list.display();
        list.displayRev();
        list.insertLast(14);
        System.out.println();
        list.display();
        list.insertAfter(1, 56);
        System.out.println();
        list.display();
    }

    Node head;
    Node tail;

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        node.prev = null;
        if(head!=null) {
            head.prev = node;
        }
        head = node;
    }

    public void insertLast(int value){

        Node node = new Node(value);

        node.next = null;
        if(head==null){
            node.prev = null;
            head = node;
        }
        Node last = head;
        while(last.next!=null){
            last = last.next;
        }

        last.next = node;
        node.prev = last;
    }

    public void insertAfter(int after, int value){
        Node p = find(after);

        if(p==null){
            System.out.println("does not exist");
            return;
        }
        Node node = new Node(value);

        node.next = p.next;
        node.prev = p;
        p.next = node;
        if(node.next.prev!=null){
            node.next.prev = node;
        }
    }

    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + " => ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    public void displayRev(){
        Node temp = head;
        Node last = null;
        while(temp!=null){
            last = temp;
            temp = temp.next;

        }
        System.out.println();
        while(last!=null){
            System.out.print(last.value + " => ");
            last = last.prev;
        }
        System.out.print("START");
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


    private class Node{
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }
}
