package com.yssr.linkedlist;

public class CircularLL {

    public static void main(String[] args) {
        CircularLL list = new CircularLL();
        list.insert(23);
        list.insert(15);
        list.insert(19);
        list.insert(4);
        list.insert(25);
        list.display();

        list.delete(19);
        list.display();
    }

    private Node head;
    private Node tail;

    public CircularLL(){
        this.head = null;
        this.tail = null;
    }

    public void insert(int val){
        Node node = new Node(val);

        if(head==null){
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        tail =node;
    }

    public void delete(int value) {
        Node node = head;
        if (node == null) {
            return;
        }

        if(node.value == value){
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            Node n = node.next;
            if(n.value==value){
                node.next = n.next;
                break;
            }
            node = node.next;
        }while(node!=head);
    }

    public void display(){
        Node node = head;
        if(head!=null){
            do {
                System.out.print(node.value + " -> ");
                node = node.next;
            }while(node!=head);
            System.out.println("HEAD");
        }
    }

    private class Node{

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
