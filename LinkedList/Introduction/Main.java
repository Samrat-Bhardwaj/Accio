import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int d){
        this.data = d;
    }
}

public class Main {
    static Node head;
    static Node tail;

    public static void addLast(int data){
        Node nn = new Node(data); 

        if(head == null){ // in case of 0 size ll
            head = nn; // this is my first node of list 
            tail = nn; // and also my last node of list 
        } else {
            tail.next = nn; // attaching

            tail = nn; // tail = tail.next // shifting tail to last => 
        }
    }

    public static void main(String[] args) {
        head =null;
        tail = null;

        Scanner scn = new Scanner(System.in);
        System.out.println("What will be the initial size of your list");
        int n=scn.nextInt();

        System.out.println("Enter the data elements for input");

        for(int i=0; i<n; i++){
            int a = scn.nextInt();
            addLast(a);
        }
        
        System.out.println(head.data);
        System.out.println(tail.data);
    }
}
