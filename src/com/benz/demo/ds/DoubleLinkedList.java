package com.benz.demo.ds;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node{
    Node l_link;
    int data;
    Node r_link;

    public Node(Node l_link, int data, Node r_link) {
        this.l_link = l_link;
        this.data = data;
        this.r_link = r_link;
    }
}

public class DoubleLinkedList{

    private Node root,tail;
    private BufferedReader reader;

    public DoubleLinkedList()
    {
        root=tail=null;
        reader=new BufferedReader(new InputStreamReader(System.in));
    }

    public void show() throws Exception
    {
        while(true) {
            System.out.println("1.Append");
            System.out.println("2.AddAtBegin");
            System.out.println("3.AddNode");
            System.out.println("4.DeleteNode");
            System.out.println("5.Traverse");
            System.out.println("6.Exit");
            System.out.println("Enter your choice");
            int ch = Integer.valueOf(reader.readLine());

            switch (ch) {
                case 1:
                    int data_a;
                    System.out.println("Enter your data");
                    data_a = Integer.valueOf(reader.readLine());
                    append(data_a);
                    break;
                case 2:
                    int data_b;
                    System.out.println("Enter your data");
                    data_b = Integer.valueOf(reader.readLine());
                    addAtBegin(data_b);
                    break;
                case 3:
                    int pos;
                    System.out.println("Enter the position to add Node");
                    pos = Integer.valueOf(reader.readLine());
                    int data;
                    System.out.println("Enter your data");
                    data = Integer.valueOf(reader.readLine());
                    addNode(pos, data);
                    break;
                case 4: int position;
                    System.out.println("Enter the position to delete node");
                    position = Integer.valueOf(reader.readLine());
                    delete(position);break;
                case 5:
                    traverse();
                    break;
                case 6: System.exit(9);
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    private void append(int data)
    {
        Node temp=new Node(null,data,null);
        if(root==null)
             root=tail=temp;
        else{
            temp.l_link=tail;
            tail.r_link=temp;
            tail=temp;
        }
    }

    private void addAtBegin(int data)
    {
        Node temp=new Node(null,data,null);
        if(root==null)
            root=tail=temp;
        else{
            temp.r_link=root;
            root.l_link=temp;
            root=temp;
        }
    }

    private int length()
    {
        int count=0;
        if(root==null)
            return count;
        Node p=root;
        while (p!=null)
        {
            count+=1;
            p=p.r_link;
        }
        return count;
    }

    private void addNode(int pos,int data)
    {
        if(pos>length())
        {
            System.out.printf("Linked list has %d number of node(s)\n",length());
            return;
        }
        if(pos==1)
            addAtBegin(data);
        else{
            Node temp=new Node(null,data,null);
            int count=1;
            Node p=root;
            while (count<pos-1)
            {
                p=p.r_link;
                count+=1;
            }
            Node q = p.r_link;
            temp.r_link=q;
            p.r_link=temp;
            q.l_link=temp;
            temp.l_link=p;
        }
    }

    private void deleteAtBegin()
    {
        Node p=root;
        root=p.r_link;
        p.r_link=null;
        root.l_link=null;
    }

    private void deleteAppend()
    {
        Node p=tail.l_link;
        tail.l_link=null;
        p.r_link=null;
        tail=p;
    }

    private void delete(int pos)
    {
        if(pos>length()) {
            System.out.printf("Linked list has %d number of node(s)\n", length());
            return;
        }
        if(pos==1)
            deleteAtBegin();
        else if(pos==length())
            deleteAppend();
        else{
            int count=1;
            Node p =root;
            while (count<pos-1)
            {
                p=p.r_link;
                count+=1;
            }
            Node q,r;
            q=p.r_link;
            r=q.r_link;

            r.l_link=p;
            p.r_link=r;
            q.r_link=null;
            q.l_link=null;
        }
    }

    private void traverse()
    {
        if(root==null) {
            System.out.println("No node(s) in the list");
            return;
        }
        Node temp=root;
        while(temp!=null)
        {
            System.out.printf("%d ---> ",temp.data);
            temp=temp.r_link;
        }
        System.out.print("\n");
    }

}
