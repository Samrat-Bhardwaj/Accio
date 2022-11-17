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

    public static void addFirst(int data){
        Node nn = new Node(data);

        if(head == null){
            head = nn;
            tail =nn;
        } else {
            nn.next = head;
            head = nn;
        }
    }

    // homework 
    public static void display(){
        Node curr = head;

        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }

    public static void removeFirst(){
        if(head!=null){ //  should atleast have one node to remove
            head = head.next;
        } 
    }

    public static Node getAt(int idx){
        if(idx < 0){
            System.out.println("given index is out of range");
            return null;
        }

        Node curr = head;
        for(int i=0; i<idx; i++){
            if(curr==null){
                System.out.println("given index is out of range");
                return null;
            }
            curr=curr.next;
        }

        return curr;
    }

    public static void addAt(int idx, int data){

    }

    public static void main(String[] args) {
        head = null;
        tail = null;

        Scanner scn = new Scanner(System.in);
        System.out.println("What will be the initial size of your list");
        int n=scn.nextInt();

        System.out.println("Enter the data elements for input");

        for(int i=0; i<n; i++){
            int a = scn.nextInt();
            addLast(a);
        }

        display();
        
        addAt(3, 15);

        display();
    }
}
