package com.benz.demo.ds;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinarySearchTree {

    private Node root;
    private BufferedReader reader;

    public BinarySearchTree(){
        root=null;
        reader=new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() throws Exception{

        while(true) {
            System.out.println("1.Insertion");
            System.out.println("2.Deletion");
            System.out.println("3.Traverse");
            System.out.println("Enter Your Choice");
            int ch=Integer.valueOf(reader.readLine());
            switch (ch){
                case 1: int data;
                    System.out.println("Enter a value to store");
                    data = Integer.valueOf(reader.readLine());
                    addNode(data);break;
                case 2: int d;
                    System.out.println("Enter a value to delete");
                    d = Integer.valueOf(reader.readLine());
                    deleteNode(d);break;
                case 3: inOrderTraverse(root);
                        System.out.print("\n");
                        break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }



    private void addNode(int data){
        Node node=new Node(null,data,null);

         if(root==null)
             root=node;
         else {
             Node curr=root;
             Node p=curr;

             while(curr!=null){
                 p=curr;
                 if(data>curr.data)
                     curr=curr.r_link;
                 else
                     curr=curr.l_link;
             }

             if(data>p.data)
                 p.r_link=node;
             else
                 p.l_link=node;
         }
    }

    private void deleteNode(int data){
        Node t = root;
        Node p=t;
        while(t!=null && data !=t.data){
            p=t;
            if(data>t.data)
                t=t.r_link;
            else
                t=t.l_link;
        }
        if(t==null)
            System.out.printf("No node available with %d\n",data);
        else if(t.l_link==null && t.r_link==null)
            nodeHavingNoChild(data,p);
        else if(t.r_link!=null && t.l_link==null ||
            t.l_link!=null && t.r_link==null)
            nodeHavingSingleChild(t,p);
        else
            nodeHavingTwoChild(t);
    }

    private void nodeHavingTwoChild(Node t){
           Node t_p = maximumValue(t.l_link);
           if(t_p.r_link!=null){
               t.data=t_p.r_link.data;
               t_p.r_link=t_p.r_link.l_link;
           }else{
               t.data=t_p.data;
               t.l_link=t_p.l_link;
           }
    }

    private Node maximumValue(Node t_p)
    {
        if(t_p.r_link==null)
            return t_p;
        return findMaximumValue(t_p);
    }

    private Node findMaximumValue(Node t_p){

        if(t_p.r_link!=null) {
            findMaximumValue(t_p.r_link);
        }
        return t_p;
    }

    private void nodeHavingSingleChild(Node t,Node p){

        if(t.data==p.data){
            if(t.l_link!=null) {
                root = t.l_link;
                t.l_link = null;
            }else{
                root=t.r_link;
                t.r_link=null;
            }
        }
        else if(t.r_link!=null){
            if(t.r_link.data>p.data)
                p.r_link=t.r_link;
            else
                p.l_link=t.r_link;
            t.r_link=null;
        }else{
            if(t.l_link.data>p.data)
                p.r_link=t.l_link;
            else
                p.l_link=t.l_link;
            t.l_link=null;
        }
    }

    private void nodeHavingNoChild(int data,Node p){
        if(data==p.data){
            root=null;
        }else if(data>p.data)
            p.r_link=null;
        else
            p.l_link=null;
    }

    private void inOrderTraverse(Node node){

        if(root==null)
            System.out.println("no node in the tree");
        else {
            if (node.l_link != null)
                inOrderTraverse(node.l_link);
            System.out.printf("%d\t", node.data);
            if (node.r_link != null)
                inOrderTraverse(node.r_link);
        }
    }

}
