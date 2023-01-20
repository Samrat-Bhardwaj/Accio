class Node {
    int data;
    Node next;

    public Node(){

    }

    public Node(int data){
        this.data = data;
    }
}

public class Main {
    static Node head;
    static Node tail;

    public static void addLast(int value){
        Node nn = new Node(value);

        if(head == null){
            head = nn;
            tail = nn;
        } else {
            tail.next = nn;
            tail = nn;
        }
    }

    public static void printLinkedList(Node n1){
        Node curr = n1;

        while(curr!=null){
            System.out.println(curr.data);
            
            Node nextNode = curr.next;
            curr = nextNode;
        }
    }
    public static void main(String[] args) {
        head = null;
        tail = null;
       
        addLast(5);
        addLast(7);
        addLast(11);

        printLinkedList(head);
    }    
}
