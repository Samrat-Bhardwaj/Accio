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
        if(head==null){ //  should atleast have one node to remove
            System.out.println("Cant remove anything");
        } else if(head == tail){
            head = null;
            tail = null;
        } else {
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
        if(idx==0){
            addFirst(data);
            return;
        }

        Node nn = new Node(data);

        Node curr = getAt(idx-1);
        Node nextOfCurr = curr.next;

        curr.next= nn;
        nn.next = nextOfCurr;
    }

    public static Node removeLast(){
        if(head==null){ // 0 size
            return null;
        } else if(head==tail){ // 1 size
            Node tr=tail;
            removeFirst();
            return tr;
        } else {
            Node curr = head;
            while(curr.next!=tail){
                curr = curr.next;
            }

            curr.next=null;
            // updating tail
            Node tr = tail;
            tail = curr;

            return tr;
        }
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
        
        Node ans = removeLast();
        if(ans!=null)
            System.out.println(ans.data);

        display();
    }
}
