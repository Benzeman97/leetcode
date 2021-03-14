package com.benz.demo.ds;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedList {

    static class Node {
        int data;
        Node link;

        public Node(int data, Node link) {
            this.data = data;
            this.link = link;
        }
    }

    private Node root;

    private BufferedReader reader;

    public LinkedList() {
        root = null;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void show() throws IOException {
        while (true) {
            System.out.println("1.append");
            System.out.println("2.addAtBegin");
            System.out.println("3.addNode");
            System.out.println("4.delete");
            System.out.println("5.display");
            System.out.println("6.swap");
            System.out.println("7.Reverse");

            System.out.println("Enter your choice");
            int ch = Integer.valueOf(reader.readLine());
            switch (ch) {
                case 1:
                    System.out.println("Enter a value to add the node at the end");
                    int a_data = Integer.valueOf(reader.readLine());
                    append(a_data);
                    break;
                case 2:
                    System.out.println("Enter a value to add the node at the begin");
                    int b_data = Integer.valueOf(reader.readLine());
                    addAtBegin(b_data);
                    break;
                case 3:
                    System.out.println("Enter a value to add the node to the specific position");
                    int p_data = Integer.valueOf(reader.readLine());
                    System.out.println("Enter the position to add the node");
                    int pos = Integer.valueOf(reader.readLine());
                    addNode(p_data, pos);
                    break;
                case 4:
                    System.out.println("Enter the location to remove the node");
                    int loc = Integer.valueOf(reader.readLine());
                    deleteNode(loc);
                    break;
                case 5:
                    display();
                    break;
                case 6:
                    System.out.println("Enter the location to swap the node");
                    int s_loc = Integer.valueOf(reader.readLine());
                    swap(s_loc);
                    break;
                case 7:
                    reverse();
                    break;
                default:
                    System.out.println("Invalid Input");

            }

        }
    }

    public void append(int data) {
        Node temp = new Node(data, null);

        if (root == null)
            root = temp;
        else {
            Node p = root;
            while (p.link != null)
                p = p.link;

            p.link = temp;
        }
    }

    public void addAtBegin(int data) {
        Node temp = new Node(data, null);

        if (root == null)
            root = temp;
        else {
            Node p = root;
            temp.link = p;
            root = temp;
        }
    }

    public int length() {
        int length = 0;
        Node temp = root;

        while (temp != null) {
            length += 1;
            temp = temp.link;
        }
        return length;
    }

    public void addNode(int data, int loc) {
        if (loc == 0 || loc > length())
            System.out.println("List has " + length() + " node(s)");
        else if (loc == 1) {
            Node temp = new Node(data, null);
            Node p = root;
            temp.link = p;
            root = temp;
        } else {
            Node temp = new Node(data, null);
            int count = 1;
            Node p;
            p = root;
            while (count < loc - 1) {
                p = p.link;
                count += 1;
            }
            temp.link = p.link;
            p.link = temp;

        }
    }

    public void deleteNode(int loc) {
        if (root != null)
            if (loc <= length())
                if (loc == 1) {
                    Node temp = root;
                    root = temp.link;
                    temp.link = null;
                } else {
                    Node p, q;
                    p = root;
                    int c = 1;
                    while (c < loc - 1) {
                        p = p.link;
                        c += 1;
                    }
                    q = p.link;
                    p.link = q.link;
                    q.link = null;

                }
            else
                System.out.println("List has " + length() + " node(s)");
        else
            System.out.println("No node(s) available in the list");

    }

    public void swap(int loc) {
        if (root != null) {
            if (loc < length()) {
                if (loc == 1) {
                    Node p, q, r;
                    p = root;
                    q = p.link;
                    r = q.link;

                    p.link = r;
                    q.link = p;
                    root = q;

                } else {

                    Node p, q, r;
                    p = root;
                    int c = 1;
                    while (c < loc - 1) {
                        p = p.link;
                        c += 1;
                    }
                    q = p.link;
                    r = q.link;

                    q.link = r.link;
                    r.link = q;
                    p.link = r;


                }
            } else
                System.out.println("List has " + length() + " node(s)");
        } else
            System.out.println("List has " + length() + " node(s)");

    }

    public void display() {
        if (root == null)
            System.out.println("No node(s) available in the list");
        else {
            Node temp = root;
            while (temp != null) {
                System.out.print(temp.data + "----->");
                temp = temp.link;
            }
            System.out.print("\n");
        }
    }

    public void reverse() {
        Node prev = null;
        Node curr = root;
        Node next = null;

        while (curr != null) {
            next = curr.link;
            curr.link = prev;
            prev = curr;
            curr = next;
        }
        root = prev;
    }
}
